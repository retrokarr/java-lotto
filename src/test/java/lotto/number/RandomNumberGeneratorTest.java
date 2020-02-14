package lotto.number;

import lotto.util.LottoStatics;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @Test
    void randomNumberGeneratorTest() {
        List<Integer> numbers = new RandomNumberGenerator().generate();

        assertThat(numbers).isNotNull();
        assertThat(numbers.size()).isEqualTo(LottoStatics.NUMBER_OF_LOTTO_NUMBER);
    }
}