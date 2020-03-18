package lotto.ticket;

import lotto.number.LottoNumber;
import lotto.prize.LottoPrize;

import java.util.*;

import static lotto.util.LottoStatics.NUMBER_OF_LOTTO_NUMBER;

public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        inputCheck(numbers);

        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public LottoPrize winningCheck(WinningLottoTicket winningLottoTicket) {
        int matchCount = (int) winningLottoTicket.getLottoNumbers()
                .stream()
                .filter(numbers::contains)
                .count();

        return LottoPrize.ofMatchCount(matchCount, numbers.contains(winningLottoTicket.getBonusNumber()));
    }

    public List<LottoNumber> getNumbers() {
        return new ArrayList<>(numbers);
    }

    private void inputCheck(List<LottoNumber> numbers) {
        if(numbers == null) {
            throw new IllegalArgumentException("Invalid input : numbers is null");
        }

        if(new HashSet<>(numbers).size() != NUMBER_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException("Invalid input : number is duplicated");
        }
    }
}
