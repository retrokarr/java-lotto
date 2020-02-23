package lotto.prize;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum LottoPrize {
    FIRST_PRIZE(6, 2000000000),
    SECOND_PRIZE(5, 1500000),
    THIRD_PRIZE(4, 50000),
    FOURTH_PRIZE(3, 5000),
    NONE(0, 0);

    private static final Map<Integer, LottoPrize> prizes = Collections.unmodifiableMap(
            Stream.of(values())
                    .collect(Collectors.toMap(LottoPrize::getMatchCount, Function.identity()))
    );

    private int prizeMoney;
    private int matchCount;

    LottoPrize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public static LottoPrize ofMatchCount(int matchCount) {
        return prizes.getOrDefault(matchCount, NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
