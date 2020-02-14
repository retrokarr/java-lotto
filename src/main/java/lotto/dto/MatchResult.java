package lotto.dto;

import lotto.prize.LottoPrizes;

public class MatchResult {
    private int payment;
    private LottoPrizes lottoPrizes;

    public MatchResult(int payment, LottoPrizes lottoPrizes) {
        this.payment = payment;
        this.lottoPrizes = lottoPrizes;
    }

    public int getPayment() {
        return payment;
    }

    public LottoPrizes getPrizes() {
        return lottoPrizes;
    }
}
