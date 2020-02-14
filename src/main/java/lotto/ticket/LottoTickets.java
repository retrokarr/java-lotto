package lotto.ticket;

import java.util.List;

public class LottoTickets {
    List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        if(lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("Tickets art not exist");
        }

        this.lottoTickets = lottoTickets;
    }
}
