package lotto.ticket;

import lotto.number.LottoNumber;
import lotto.prize.LottoPrizes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.prize.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @Test
    void lottoTicketsTest() {
        assertThat(new LottoTickets(Arrays.asList(
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        ))).isNotNull();
    }

    @ParameterizedTest
    @NullSource
    void invalidInputTest(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> new LottoTickets(lottoTickets)).isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest
    @MethodSource
    void winningCheckTest(List<LottoNumber> numbers, int bonusNumber, int countOfNone, int countOfFifth, int countOfFourth, int countOfThird, int countOfSecond, int countOfFirst) {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(8))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(8), new LottoNumber(9))),
                new LottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10)))
        ));

        LottoPrizes lottoPrizes = lottoTickets.winningCheck(new WinningLottoTicket(numbers, new LottoNumber(bonusNumber)));

        assertThat(lottoPrizes.countOfPrize(NONE)).isEqualTo(countOfNone);
        assertThat(lottoPrizes.countOfPrize(FIFTH_PRIZE)).isEqualTo(countOfFifth);
        assertThat(lottoPrizes.countOfPrize(FOURTH_PRIZE)).isEqualTo(countOfFourth);
        assertThat(lottoPrizes.countOfPrize(THIRD_PRIZE)).isEqualTo(countOfThird);
        assertThat(lottoPrizes.countOfPrize(SECOND_PRIZE)).isEqualTo(countOfSecond);
        assertThat(lottoPrizes.countOfPrize(FIRST_PRIZE)).isEqualTo(countOfFirst);
    }

    private static Stream winningCheckTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), 7, 0, 1, 1, 1, 1, 1),
                Arguments.of(Arrays.asList(new LottoNumber(45), new LottoNumber(44), new LottoNumber(43), new LottoNumber(42), new LottoNumber(41), new LottoNumber(40)), 7, 5, 0, 0, 0, 0, 0),
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(45), new LottoNumber(44), new LottoNumber(43)), 7, 0, 5, 0, 0, 0, 0)
        );
    }
}