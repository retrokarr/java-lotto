package lotto.dto;

import lotto.ticket.LottoTicket;

import java.util.Collections;
import java.util.List;

public class PurchaseInfo {
    private List<LottoTicket> lottoTickets;

    public PurchaseInfo(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int purchaseCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
