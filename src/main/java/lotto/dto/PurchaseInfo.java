package lotto.dto;

import lotto.ticket.LottoTickets;

public class PurchaseInfo {
    private LottoTickets lottoTickets;

    public int purchaseCount() {
        return lottoTickets.ticketCount();
    }
}
