package lotto.prize;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {
    FIRST_PRIZE(6, false, 2000000000),
    SECOND_PRIZE(5, true, 30000000),
    THIRD_PRIZE(5, false, 1500000),
    FOURTH_PRIZE(4, false, 50000),
    FIFTH_PRIZE(3, false, 5000),
    NONE(0, false, 0);

    private static final Map<Integer, LottoPrize> prizes = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoPrize::getMatchCount, Function.identity(), (pre, post) -> post))
    );

    private int prizeMoney;
    private int matchCount;
    private boolean bonusMatch;

    LottoPrize(int matchCount, boolean bonusMatch, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.bonusMatch = bonusMatch;
    }

    public static LottoPrize ofMatchCount(int matchCount, boolean bonusMatch) {
        LottoPrize prize = prizes.getOrDefault(matchCount, NONE);

        if(prize == THIRD_PRIZE && bonusMatch) {
            return SECOND_PRIZE;
        }

        return prize;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatching() {
        return bonusMatch;
    }
}
