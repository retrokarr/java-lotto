package lotto;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.handlebar.CustomHandlebarsTemplateEngine;
import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.TicketPayment;
import lotto.ticket.WinningLottoTicket;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebMain {
    public static void main(String[] args) {
        port(8080);

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return render(model, "/index.html");
        });

        post("/buyLotto", (req, res) -> {
            Integer inputMoney = Integer.parseInt(req.queryParamOrDefault("inputMoney", "0"));
            String[] manualNumberStrings = req.queryParamOrDefault("manualNumber", "")
                                            .split("\n");

            List<LottoTicket> lottoTickets = Arrays.stream(manualNumberStrings)
                    .map(ConsoleInput::convertToNumber)
                    .map(LottoTicket::new)
                    .collect(Collectors.toList());

            Lotto lotto = Lotto.buy(new TicketPayment(inputMoney, new LottoTickets(lottoTickets)));

            req.session().attribute("lotto", lotto);

            PurchaseInfo purchaseInfo = lotto.purchaseInfo();
            Map<String, Object> model = new HashMap<>();
            model.put("purchaseInfo", lotto.purchaseInfo());
            model.put("count", purchaseInfo.purchaseCount());
            model.put("tickets", purchaseInfo.getTickets());

            return render(model, "/show.html");
        });

        post("/matchLotto", (req, res) -> {
            Lotto lotto = req.session().attribute("lotto");

            String winningNumber  = req.queryParamOrDefault("winningNumber", "");
            Integer bonusNumber = Integer.parseInt(req.queryParamOrDefault("bonusNumber", "0"));
            MatchResult matchResult = lotto.winningCheck(new WinningLottoTicket(ConsoleInput.convertToNumber(winningNumber), new LottoNumber(bonusNumber)));

            Map<String, Object> model = new HashMap<>();
            model.put("revenue", ConsoleOutput.getRevenue(matchResult));
            model.put("resultString", ConsoleOutput.getLottoPrizesResultString(matchResult));

            return render(model, "/result.html");
        });
    }

    private static String render(Map<String, Object> model, String templatePath) {
        return new CustomHandlebarsTemplateEngine().render(new ModelAndView(model, templatePath));
    }
}
