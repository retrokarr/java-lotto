package lotto.number;

import lotto.Lottos;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void numberGeneratorTest() {
        assertThat(((NumberGenerator) () -> Lottos.asList(1, 2, 3, 4, 5, 6)).generate())
                .contains(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                );
    }
}