package lotto.number;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}