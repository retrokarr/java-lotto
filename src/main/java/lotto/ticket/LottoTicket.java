package lotto.ticket;

import lotto.prize.LottoPrize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.LottoStatics.NUMBER_OF_LOTTO_NUMBER;

public class LottoTicket {
    List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        inputCheck(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public LottoPrize winningCheck(WinningLottoTicket winningLottoTicket) {
        int matchCount = (int) winningLottoTicket.getLottoNumbers()
                .stream()
                .filter(numbers::contains)
                .count();

        return LottoPrize.ofMatchCount(matchCount);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void inputCheck(List<Integer> numbers) {
        if(numbers == null || numbers.size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Invalid input : numbers is null or size is not " + NUMBER_OF_LOTTO_NUMBER);
        }
    }
}
