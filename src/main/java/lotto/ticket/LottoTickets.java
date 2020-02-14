package lotto.ticket;

import lotto.number.NumberGenerator;
import lotto.number.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {
    List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        if(lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("Tickets art not exist");
        }

        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets buy(int affordableCount) {
        return buy(affordableCount, new RandomNumberGenerator());
    }

    public static LottoTickets buy(int affordableCount, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTickets = IntStream.rangeClosed(0, affordableCount)
                .mapToObj(x -> new LottoTicket(numberGenerator.generate()))
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }
}
