package lotto.ticket;

import java.util.Collections;
import java.util.List;

import static lotto.util.LottoStatics.LIMIT_OF_LOTTO_NUMBER;
import static lotto.util.LottoStatics.START_OF_LOTTO_NUMBER;

public class WinningLottoTicket extends LottoTicket {
    private int bonusNumber;

    public WinningLottoTicket(List<Integer> numbers, int bonusNumber) {
        super(numbers);

        validate(numbers, bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(getNumbers());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<Integer> numbers, int bonusNumber) {
        rangeCheckOfBonusNumber(bonusNumber);

        duplicationCheckOfBonusNumber(numbers, bonusNumber);
    }

    private void duplicationCheckOfBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Duplicated number");
        }
    }

    private void rangeCheckOfBonusNumber(int bonusNumber) {
        if(bonusNumber < START_OF_LOTTO_NUMBER || bonusNumber > LIMIT_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Wrong input of bonus number : [" + bonusNumber + "]");
        }
    }
}
