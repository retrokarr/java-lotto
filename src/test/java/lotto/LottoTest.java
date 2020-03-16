package lotto;

import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.TicketPayment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import java.util.Arrays;

import static lotto.util.LottoStatics.PRICE_OF_LOTTO_TICKET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void buyLottoTest() {
        int payment = 10000;
        TicketPayment ticketPayment = new TicketPayment(payment, new LottoTickets(Arrays.asList(new LottoTicket(Lottos.asList(1, 2, 3, 4, 5, 6)))));

        Lotto lotto = Lotto.buy(ticketPayment);

        assertThat(lotto).isNotNull();
        assertThat(lotto.purchaseInfo().purchaseCount()).isEqualTo(payment / PRICE_OF_LOTTO_TICKET);
    }

    @ParameterizedTest
    @NullSource
    void invalidInputTest(TicketPayment ticketPayment) {
        assertThatThrownBy(() -> Lotto.buy(ticketPayment)).isInstanceOf(IllegalArgumentException.class);
    }
}