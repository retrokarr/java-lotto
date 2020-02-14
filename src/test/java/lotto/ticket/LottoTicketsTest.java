package lotto.ticket;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketsTest {

    @Test
    void lottoTicketsTest() {
        assertThat(new LottoTickets(Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))
        ))).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    void invalidInputTest(List<LottoTicket> lottoTickets) {
        assertThatThrownBy(() -> new LottoTickets(lottoTickets)).isInstanceOf(IllegalArgumentException.class);
    }
}