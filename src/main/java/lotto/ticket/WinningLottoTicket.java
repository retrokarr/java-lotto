package lotto.ticket;

import java.util.Collections;
import java.util.List;

public class WinningLottoTicket extends LottoTicket {
    private int bonusNumber;

    public WinningLottoTicket(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        if(numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Duplicated number");
        }

        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(getNumbers());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
