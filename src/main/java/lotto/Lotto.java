package lotto;

import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.ticket.LottoTickets;
import lotto.ticket.TicketPayment;
import lotto.ticket.WinningLottoTicket;

public class Lotto {
    private TicketPayment ticketPayment;
    private LottoTickets lottoTickets;

    private Lotto(TicketPayment ticketPayment) {
        checkInput(ticketPayment);

        this.ticketPayment = ticketPayment;
        this.lottoTickets = ticketPayment.addLottoTickets(
                LottoTickets.buy(ticketPayment.affordableTicketCount())
        );
    }

    public static Lotto buy(TicketPayment ticketPayment) {
        return new Lotto(ticketPayment);
    }

    public PurchaseInfo purchaseInfo() {
        return new PurchaseInfo(ticketPayment, lottoTickets.getTickets());
    }

    public MatchResult winningCheck(WinningLottoTicket winningLottoTicket) {
        return new MatchResult(ticketPayment, lottoTickets.winningCheck(winningLottoTicket));
    }

    private void checkInput(TicketPayment ticketPayment) {
        if(ticketPayment == null) {
            throw new IllegalArgumentException("Invalid input. ticket payment must not be a null");
        }
    }
}
