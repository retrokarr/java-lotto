package lotto.ticket;

import lotto.Lottos;
import lotto.number.LottoNumber;
import lotto.prize.LottoPrize;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static lotto.prize.LottoPrize.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {
    @Test
    void ticketTest() {
        assertThat(new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    @NullAndEmptySource
    void illegalInputTest(List<LottoNumber> numbers) {
        assertThatThrownBy(() -> new LottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream illegalInputTest() {
        return Stream.of(
                Arguments.of(Lottos.asList(1)),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5)),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource
    void winningCheckTest(List<LottoNumber> numbers, int bonusNumber, LottoPrize lottoPrize) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)), new LottoNumber(bonusNumber));
        assertThat(new LottoTicket(numbers).winningCheck(winningLottoTicket)).isEqualTo(lottoPrize);
    }

    private static Stream winningCheckTest() {
        return Stream.of(
                Arguments.of(Lottos.asList(8, 9, 10, 11, 12, 13), 7,  NONE),
                Arguments.of(Lottos.asList(1, 9, 10, 11, 12, 13), 7, NONE),
                Arguments.of(Lottos.asList(1, 2, 10, 11, 12, 13), 7, NONE),
                Arguments.of(Lottos.asList(1, 2, 3, 11, 12, 13), 7, FIFTH_PRIZE),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 12, 13), 7, FOURTH_PRIZE),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 13), 7, THIRD_PRIZE),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 13), 13, SECOND_PRIZE),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 6), 7, FIRST_PRIZE)
        );
    }

}