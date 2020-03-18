package lotto.dto;

import lotto.ticket.LottoTicket;
import lotto.ticket.TicketPayment;

import java.util.Collections;
import java.util.List;

public class PurchaseInfo {
    private TicketPayment ticketPayment;
    private List<LottoTicket> lottoTickets;

    public PurchaseInfo(TicketPayment ticketPayment, List<LottoTicket> lottoTickets) {
        this.ticketPayment = ticketPayment;
        this.lottoTickets = lottoTickets;
    }

    public int purchaseCount() {
        return lottoTickets.size();
    }

    public List<LottoTicket> getTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int getManualTicketCount() {
        return ticketPayment.manualTicketCount();
    }

    public int getAutoTicketCount() {
        return ticketPayment.affordableTicketCount();
    }
}
