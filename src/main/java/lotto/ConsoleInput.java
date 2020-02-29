package lotto;

import lotto.ticket.WinningLottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String SPLIT = ",";

    public static int receiveMoney() {
        System.out.println("구매금액을 입력해 주세요.");

        int payment = SCANNER.nextInt();
        SCANNER.nextLine();

        return payment;
    }

    public static WinningLottoTicket receiveWinningLotto() {
        System.out.println("지난 주 당첨 번호를 임력해 주세요.");
        String winningNumberString = SCANNER.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = SCANNER.nextInt();

        return new WinningLottoTicket(convertToNumber(winningNumberString), bonusNumber);
    }

    private static List<Integer> convertToNumber(String winningNumberString) {
        return Arrays.stream(winningNumberString.split(SPLIT))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
