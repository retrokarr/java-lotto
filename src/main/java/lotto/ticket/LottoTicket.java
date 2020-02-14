package lotto.ticket;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        if(numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("Invalid input : numbers is null or size is not 6");
        }

        Collections.sort(numbers);
        this.numbers = numbers;
    }
}
