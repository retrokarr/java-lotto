package lotto.ticket;

import static lotto.util.LottoStatics.PRICE_OF_LOTTO_TICKET;

public class TicketPayment {
    private int payment;
    private LottoTickets manualTickets;

    public TicketPayment(int payment, LottoTickets manualTickets) {
        checkPayment(payment);
        checkManualTickets(payment, manualTickets);

        this.payment = payment;
        this.manualTickets = manualTickets;
    }

    public LottoTickets addLottoTickets(LottoTickets automaticTickets) {
        return manualTickets.addTickets(automaticTickets);
    }

    public int affordableTicketCount() {
        return payment / PRICE_OF_LOTTO_TICKET - manualTickets.getTickets().size();
    }

    public int getPayment() {
        return payment;
    }

    // 중복이 있더라도 미리 체크하는게 맞지 않을까?
    public static void ticketCheck(int payment, int numberOfManualTicket) {
        checkPayment(payment);
        checkNumberOfManualTickets(payment, numberOfManualTicket);
    }

    private static void checkPayment(int payment) {
        if(payment <= 0) {
            throw new IllegalArgumentException("Invalid input. payment should be greater than 0");
        }
    }

    private static void checkNumberOfManualTickets(int payment, int numberOfManualTicket) {
        if(numberOfManualTicket < 0) {
            throw new IllegalArgumentException("Invalid input. number of manual ticket must be greater than equal to 0");
        }

        int affordableCount = payment / PRICE_OF_LOTTO_TICKET;

        if(affordableCount < numberOfManualTicket) {
            throw new IllegalArgumentException("Invalid input. too many manual ticket");
        }
    }

    private static void checkManualTickets(int payment, LottoTickets lottoTickets) {
        if(lottoTickets == null) {
            throw new IllegalArgumentException("Tickets are null");
        }

        checkNumberOfManualTickets(payment, lottoTickets.getTickets().size());
    }
}
