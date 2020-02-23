package lotto.prize;

import java.util.HashMap;
import java.util.Map;

public class LottoPrizes {
    private Map<LottoPrize, Integer> prizes = new HashMap<>();

    public void addPrize(LottoPrize prize) {
        int previousCount = prizes.getOrDefault(prize, 0);

        prizes.put(prize, previousCount + 1);
    }

    public int countOfPrize(LottoPrize prize) {
        return prizes.getOrDefault(prize, 0);
    }
}
