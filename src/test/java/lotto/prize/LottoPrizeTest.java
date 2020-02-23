package lotto.prize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {"0, NONE", "2, NONE", "3, FOURTH_PRIZE", "4, THIRD_PRIZE", "5, SECOND_PRIZE", "6, FIRST_PRIZE"})
    void LottoPrizeTest(int matchCount, LottoPrize prize) {
        assertThat(LottoPrize.ofMatchCount(matchCount)).isEqualByComparingTo(prize);
    }
}