package lotto.number;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    void numberGeneratorTest() {
        assertThat(((NumberGenerator) () -> Arrays.asList(1, 2, 3, 4, 5, 6)).generate())
                .contains(1, 2, 3, 4, 5, 6);
    }
}