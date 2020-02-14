package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void buyLottoTest() {
        Lotto lotto = Lotto.buy(10000);

        assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void invalidInputTest(int payment) {
        assertThatThrownBy(() -> Lotto.buy(payment)).isInstanceOf(IllegalArgumentException.class);
    }
}