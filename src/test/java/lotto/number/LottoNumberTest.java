package lotto.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidInputTest(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void constructorTest(int number) {
        assertThat(new LottoNumber(number)).isNotNull();
    }

    @Test
    void equalsTest() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test
    void comparableTest() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(10));
        lottoNumbers.add(new LottoNumber(20));

        assertThat(lottoNumbers.get(0)).isEqualTo(new LottoNumber(10));
        assertThat(lottoNumbers.get(1)).isEqualTo(new LottoNumber(20));

        Collections.sort(lottoNumbers);

        assertThat(lottoNumbers.get(0)).isEqualTo(new LottoNumber(20));
        assertThat(lottoNumbers.get(1)).isEqualTo(new LottoNumber(10));
    }
}