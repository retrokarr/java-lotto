package lotto.ticket;

import lotto.Lottos;
import lotto.number.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTicketTest {
    @Test
    void winningLottoTicketTest() {
        assertThat(new WinningLottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6), new LottoNumber(7))).isNotNull();
    }

    @MethodSource
    @ParameterizedTest
    void illegalInputTest(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        assertThatThrownBy(() -> new WinningLottoTicket(numbers, bonusNumber)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream illegalInputTest() {
        return Stream.of(
                Arguments.of(null, new LottoNumber(1)),
                Arguments.of(Arrays.asList(), new LottoNumber(1)),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5), new LottoNumber(7)),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 6), new LottoNumber(6)),
                Arguments.of(Lottos.asList(1, 2, 3, 4, 5, 6, 7), new LottoNumber(8))
        );
    }
}