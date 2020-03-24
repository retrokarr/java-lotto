package lotto;

import lotto.number.LottoNumber;
import lotto.ticket.LottoTicket;
import lotto.ticket.LottoTickets;
import lotto.ticket.TicketPayment;
import lotto.ticket.WinningLottoTicket;

import java.util.*;
import java.util.stream.Collectors;

public class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT = ",";

    public static TicketPayment receiveInputs() {
        int payment = receiveMoney();
        int manualTicketCount = receiveManualCount();

        TicketPayment.ticketCheck(payment, manualTicketCount);

        LottoTickets manualTickets = receiveManualTicket(manualTicketCount);

        return new TicketPayment(payment, manualTickets);
    }

    private static LottoTickets receiveManualTicket(int manualTicketCount) {
        if(manualTicketCount == 0) {
            return new LottoTickets(Collections.emptyList());
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<LottoTicket> manualTickets = new ArrayList<>();

        while(manualTicketCount-- > 0) {
            manualTickets.add(new LottoTicket(convertToNumber(SCANNER.nextLine())));
        }

        return new LottoTickets(manualTickets);
    }

    public static int receiveMoney() {
        System.out.println("구매금액을 입력해 주세요.");

        int payment = SCANNER.nextInt();
        SCANNER.nextLine();

        return payment;
    }

    public static int receiveManualCount() {
        System.out.println("수동으로 구매할 로또 수 입력해주세요.");

        int manualCount = SCANNER.nextInt();
        SCANNER.nextLine();

        return manualCount;
    }

    public static WinningLottoTicket receiveWinningLotto() {
        System.out.println("지난 주 당첨 번호를 임력해 주세요.");
        String winningNumberString = SCANNER.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = SCANNER.nextInt();

        return new WinningLottoTicket(convertToNumber(winningNumberString), new LottoNumber(bonusNumber));
    }

    public static List<LottoNumber> convertToNumber(String winningNumberString) {
        return Arrays.stream(winningNumberString.split(SPLIT))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
