package lotto.ticket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {
    @Test
    void winningLottoTicketTest() {
        assertThat(new WinningLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @MethodSource
    @ParameterizedTest
    @NullAndEmptySource
    void illegalInputTest(List<Integer> numbers) {
        assertThatThrownBy(() -> new WinningLottoTicket(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream illegalInputTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}