package lotto.ticket;

import lotto.Lottos;
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
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6))
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
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 7)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 8)),
                new LottoTicket(Lottos.asList(1, 2, 3, 4, 8, 9)),
                new LottoTicket(Lottos.asList(1, 2, 3, 8, 9, 10))
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
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 6), 7, 0, 1, 1, 1, 1, 1),
                Arguments.of(Lottos.asList(45, 44, 43, 42, 41, 40), 7, 5, 0, 0, 0, 0, 0),
                Arguments.of(Lottos.asList(1, 2, 3, 45, 44, 43), 7, 0, 5, 0, 0, 0, 0)
        );
    }
}