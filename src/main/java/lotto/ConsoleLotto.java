package lotto;

import lotto.dto.MatchResult;

public class ConsoleLotto {

    public static void main(String[] args) {
        Lotto lotto = Lotto.buy(ConsoleInput.receiveInputs());

        ConsoleOutput.showBoughtLottos(lotto.purchaseInfo());

        MatchResult matchResult = lotto.winningCheck(ConsoleInput.receiveWinningLotto());

        ConsoleOutput.showMatchResult(matchResult);
    }
}
