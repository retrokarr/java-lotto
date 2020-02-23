package lotto.ticket;

import lotto.number.NumberGenerator;
import lotto.number.RandomNumberGenerator;
import lotto.prize.LottoPrizes;

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
        List<LottoTicket> lottoTickets = IntStream.range(0, affordableCount)
                .mapToObj(x -> new LottoTicket(numberGenerator.generate()))
                .collect(Collectors.toList());

        return new LottoTickets(lottoTickets);
    }

    public int ticketCount() {
        return lottoTickets.size();
    }

    public LottoPrizes winningCheck(WinningLottoTicket winningLottoTicket) {
        LottoPrizes lottoPrizes = new LottoPrizes();

        lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.winningCheck(winningLottoTicket))
                .forEach(lottoPrizes::addPrize);

        return lottoPrizes;
    }

    public List<LottoTicket> getTickets() {
        return lottoTickets;
    }
}
