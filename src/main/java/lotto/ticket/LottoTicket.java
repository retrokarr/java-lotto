package lotto.ticket;

import java.util.Collections;
import java.util.List;

import static lotto.util.LottoStatics.NUMBER_OF_LOTTO_NUMBER;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        if(numbers == null || numbers.size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Invalid input : numbers is null or size is not " + NUMBER_OF_LOTTO_NUMBER);
        }

        Collections.sort(numbers);
        this.numbers = numbers;
    }
}
