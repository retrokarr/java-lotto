package lotto.prize;

import org.junit.jupiter.api.Test;

import static lotto.prize.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizesTest {

    @Test
    void manipulatePrizesTest() {
        LottoPrizes lottoPrizes = new LottoPrizes();

        assertThat(lottoPrizes.countOfPrize(NONE)).isEqualTo(0);
        assertThat(lottoPrizes.countOfPrize(FOURTH_PRIZE)).isEqualTo(0);
        assertThat(lottoPrizes.countOfPrize(THIRD_PRIZE)).isEqualTo(0);
        assertThat(lottoPrizes.countOfPrize(SECOND_PRIZE)).isEqualTo(0);
        assertThat(lottoPrizes.countOfPrize(FIRST_PRIZE)).isEqualTo(0);

        lottoPrizes.addPrize(NONE);

        lottoPrizes.addPrize(FOURTH_PRIZE);
        lottoPrizes.addPrize(FOURTH_PRIZE);

        lottoPrizes.addPrize(THIRD_PRIZE);
        lottoPrizes.addPrize(THIRD_PRIZE);
        lottoPrizes.addPrize(THIRD_PRIZE);

        lottoPrizes.addPrize(SECOND_PRIZE);
        lottoPrizes.addPrize(SECOND_PRIZE);

        lottoPrizes.addPrize(FIRST_PRIZE);

        assertThat(lottoPrizes.countOfPrize(NONE)).isEqualTo(1);
        assertThat(lottoPrizes.countOfPrize(FOURTH_PRIZE)).isEqualTo(2);
        assertThat(lottoPrizes.countOfPrize(THIRD_PRIZE)).isEqualTo(3);
        assertThat(lottoPrizes.countOfPrize(SECOND_PRIZE)).isEqualTo(2);
        assertThat(lottoPrizes.countOfPrize(FIRST_PRIZE)).isEqualTo(1);
    }
}