package lotto.prize;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0, false, NONE",
            "0, true, NONE",
            "2, false, NONE",
            "2, true, NONE",
            "3, false, FIFTH_PRIZE",
            "3, true, FIFTH_PRIZE",
            "4, false, FOURTH_PRIZE",
            "4, true, FOURTH_PRIZE",
            "5, false, THIRD_PRIZE",
            "5, true, SECOND_PRIZE",
            "6, false, FIRST_PRIZE",
            "6, true, FIRST_PRIZE"
    })
    void LottoPrizeTest(int matchCount, boolean bonusMatch, LottoPrize prize) {
        assertThat(LottoPrize.ofMatchCount(matchCount, bonusMatch)).isEqualByComparingTo(prize);
    }
}