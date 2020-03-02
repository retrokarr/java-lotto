package lotto.ticket;

import lotto.number.LottoNumber;

import java.util.Collections;
import java.util.List;

public class WinningLottoTicket extends LottoTicket {
    private LottoNumber bonusNumber;

    public WinningLottoTicket(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        super(numbers);

        validate(numbers, bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(getNumbers());
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    private void validate(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        duplicationCheckOfBonusNumber(numbers, bonusNumber);
    }

    private void duplicationCheckOfBonusNumber(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Duplicated number");
        }
    }
}
