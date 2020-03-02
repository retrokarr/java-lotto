package lotto.number;

import java.util.Objects;

import static lotto.util.LottoStatics.LIMIT_OF_LOTTO_NUMBER;
import static lotto.util.LottoStatics.START_OF_LOTTO_NUMBER;

public class LottoNumber implements Comparable<LottoNumber> {
    private int number;

    public LottoNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(number < START_OF_LOTTO_NUMBER || LIMIT_OF_LOTTO_NUMBER < number) {
            throw new IllegalArgumentException("Lotto number should be range in " + START_OF_LOTTO_NUMBER + " and " + LIMIT_OF_LOTTO_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber lottoNumber) {
        return lottoNumber.number - this.number;
    }
}
