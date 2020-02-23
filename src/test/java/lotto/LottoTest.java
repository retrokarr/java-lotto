package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.util.LottoStatics.PRICE_OF_LOTTO_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void buyLottoTest() {
        int payment = 10000;
        Lotto lotto = Lotto.buy(payment);

        assertThat(lotto).isNotNull();
        assertThat(lotto.purchaseInfo().purchaseCount()).isEqualTo(payment / PRICE_OF_LOTTO_TICKET);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void invalidInputTest(int payment) {
        assertThatThrownBy(() -> Lotto.buy(payment)).isInstanceOf(IllegalArgumentException.class);
    }
}