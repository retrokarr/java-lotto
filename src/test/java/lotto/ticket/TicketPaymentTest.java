package lotto.ticket;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TicketPaymentTest {

    @ParameterizedTest
    @CsvSource(value = {"1000, 2", "10000, -1", "-1, 10"})
    void invalidPreInputTest(int payment, int numberOfManualTickets) {
        assertThatThrownBy(() -> TicketPayment.ticketCheck(payment, numberOfManualTickets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1000, 1", "3000, 0", "2000, 1"})
    void preInputTest(int payment, int numberOfManualTickets) {
        TicketPayment.ticketCheck(payment, numberOfManualTickets);
    }

    @ParameterizedTest
    @MethodSource
    void ticketPaymentConstructorTest(int payment, LottoTickets lottoTickets) {
        assertThat(new TicketPayment(payment, lottoTickets)).isNotNull();
    }

    private static Stream ticketPaymentConstructorTest() {
        return Stream.of(
                Arguments.of(1000, new LottoTickets(Arrays.asList())),
                Arguments.of(1000, new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))))
        );
    }

    @ParameterizedTest
    @MethodSource
    void invalidTicketPaymentConstructorTest(int payment, LottoTickets lottoTickets) {
        assertThatThrownBy(() -> new TicketPayment(payment, lottoTickets))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream invalidTicketPaymentConstructorTest() {
        return Stream.of(
                Arguments.of(1, null),
                Arguments.of(-1, new LottoTickets(Arrays.asList(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)))))
        );
    }
}