package lotto.dto;

import lotto.prize.LottoPrizes;
import lotto.ticket.TicketPayment;

public class MatchResult {
    private TicketPayment ticketPayment;
    private LottoPrizes lottoPrizes;

    public MatchResult(TicketPayment ticketPayment, LottoPrizes lottoPrizes) {
        this.ticketPayment = ticketPayment;
        this.lottoPrizes = lottoPrizes;
    }

    public int getPayment() {
        return ticketPayment.getPayment();
    }

    public LottoPrizes getPrizes() {
        return lottoPrizes;
    }
}
