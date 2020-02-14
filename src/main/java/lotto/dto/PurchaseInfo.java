package lotto.dto;

import lotto.ticket.LottoTickets;

public class PurchaseInfo {
    private LottoTickets lottoTickets;

    public PurchaseInfo(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int purchaseCount() {
        return lottoTickets.ticketCount();
    }
}
