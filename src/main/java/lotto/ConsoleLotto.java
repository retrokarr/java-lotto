package lotto;

import com.sun.javafx.binding.StringFormatter;
import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.prize.LottoPrize;
import lotto.prize.LottoPrizes;
import lotto.ticket.LottoTicket;
import lotto.ticket.WinningLottoTicket;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleLotto {
    private static final String SPLIT = ",";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showEnterPaymentStatement();
        int payment = scanner.nextInt();
        scanner.nextLine();

        Lotto lotto = Lotto.buy(payment);
        showPurchaseInfo(lotto.purchaseInfo());

        showEnterWinningNumberStatement();
        String winningNumberString = scanner.nextLine();

        MatchResult matchResult = lotto.winningCheck(new WinningLottoTicket(convertToNumber(winningNumberString)));
        showResult(matchResult);
    }

    private static void showResult(MatchResult matchResult) {
        LottoPrizes prizes = matchResult.getPrizes();
        List<LottoPrize> lottoPrizes = new ArrayList<>(Arrays.asList(LottoPrize.values()));//https://kkwonsy.tistory.com/14
        Collections.reverse(lottoPrizes);
        lottoPrizes.remove(0);

        int revenue = 0;
        for(LottoPrize lottoPrize : lottoPrizes) {
            System.out.printf("%d개 일치(%d원)- %d개\n", lottoPrize.getMatchCount(), lottoPrize.getPrizeMoney(), prizes.countOfPrize(lottoPrize));
            revenue += lottoPrize.getPrizeMoney() * prizes.countOfPrize(lottoPrize);
        }

        System.out.printf("총 수익률은 %d%%입니다.\n", revenue / matchResult.getPayment());
    }

    private static void showEnterPaymentStatement() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    private static void showEnterWinningNumberStatement() {
        System.out.println("지난 주 당첨 번호를 임력해 주세요.");
    }

    private static void showPurchaseInfo(PurchaseInfo purchaseInfo) {
        System.out.println(purchaseInfo.purchaseCount() + "개를 구매했습니다.");

        for(LottoTicket ticket : purchaseInfo.getTickets()) {
            System.out.println(ticket.getNumbers());
        }
    }

    private static List<Integer> convertToNumber(String winningNumberString) {
        return Arrays.stream(winningNumberString.split(SPLIT))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
