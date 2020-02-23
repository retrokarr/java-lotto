package lotto.ticket;

import java.util.Collections;
import java.util.List;

public class WinningLottoTicket extends LottoTicket {
    public WinningLottoTicket(List<Integer> numbers) {
        super(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(getNumbers());
    }
}
