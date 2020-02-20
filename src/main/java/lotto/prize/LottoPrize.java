package lotto.prize;

import static lotto.util.LottoStatics.NUMBER_OF_LOTTO_NUMBER;

public enum LottoPrize {
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 1500000),
    THIRD_PRIZE(4, 50000),
    FOURTH_PRIZE(3, 5000),
    NONE(0, 0);

    private int prizeMoney;
    private int matchCount;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize ofMatchCount(int matchCount) {
        if(NUMBER_OF_LOTTO_NUMBER - matchCount > FOURTH_PRIZE.ordinal()) {
            return NONE;
        }

        return LottoPrize.values()[NUMBER_OF_LOTTO_NUMBER - matchCount];
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
