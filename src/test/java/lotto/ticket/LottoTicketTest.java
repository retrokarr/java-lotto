package lotto.ticket;

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
        assertThat(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @ParameterizedTest
    @MethodSource
    @NullAndEmptySource
    void illegalInputTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new LottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream illegalInputTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource
    void winningCheckTest(List<Integer> numbers, LottoPrize lottoPrize) {
        WinningLottoTicket winningLottoTicket = new WinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new LottoTicket(numbers).winningCheck(winningLottoTicket)).isEqualTo(lottoPrize);
    }

    private static Stream winningCheckTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(8, 9, 10, 11, 12, 13), NONE),
                Arguments.of(Arrays.asList(1, 9, 10, 11, 12, 13), NONE),
                Arguments.of(Arrays.asList(1, 2, 10, 11, 12, 13), NONE),
                Arguments.of(Arrays.asList(1, 2, 3, 11, 12, 13), FOURTH_PRIZE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 12, 13), THIRD_PRIZE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 13), SECOND_PRIZE),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), FIRST_PRIZE)
        );
    }

}