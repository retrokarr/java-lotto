package lotto;

import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.ticket.LottoTickets;
import lotto.ticket.WinningLottoTicket;

import static lotto.util.LottoStatics.PRICE_OF_LOTTO_TICKET;

public class Lotto {
    private int payment;
    private LottoTickets lottoTickets;

    private Lotto(int payment) {
        if(payment <= 0) {
            throw new IllegalArgumentException("Invalid input. payment should be greater than 0");
        }

        int affordableCount = payment / PRICE_OF_LOTTO_TICKET;

        this.payment = payment;
        this.lottoTickets = LottoTickets.buy(affordableCount);
    }

    public static Lotto buy(int payment) {
        return new Lotto(payment);
    }

    public PurchaseInfo purchaseInfo() {
        return new PurchaseInfo(lottoTickets.getTickets());
    }

    public MatchResult winningCheck(WinningLottoTicket winningLottoTicket) {
        return new MatchResult(payment, lottoTickets.winningCheck(winningLottoTicket));
    }
}
