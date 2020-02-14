package lotto.prize;

import static lotto.util.LottoStatics.NUMBER_OF_LOTTO_NUMBER;

public enum LottoPrize {
    FIRST_PRIZE,
    SECOND_PRIZE,
    THIRD_PRIZE,
    FOURTH_PRIZE,
    NONE;

    public static LottoPrize ofMatchCount(int matchCount) {
        if(NUMBER_OF_LOTTO_NUMBER - matchCount > FOURTH_PRIZE.ordinal()) {
            return NONE;
        }

        return LottoPrize.values()[NUMBER_OF_LOTTO_NUMBER - matchCount];
    }
}
