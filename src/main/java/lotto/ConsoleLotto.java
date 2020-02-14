package lotto;

import lotto.dto.PurchaseInfo;
import lotto.ticket.LottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleLotto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showEnterPaymentStatement();
        int payment = scanner.nextInt();

        Lotto lotto = Lotto.buy(payment);
        showPurchaseInfo(lotto.purchaseInfo());

        showEnterWinningNumberStatement();
        String winningNumberString = scanner.nextLine();


    }

    public static void showEnterPaymentStatement() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    public static void showEnterWinningNumberStatement() {
        System.out.println("지난 주 당첨 번호를 임력해 주세요.");
    }

    public static void showPurchaseInfo(PurchaseInfo purchaseInfo) {
        System.out.println(purchaseInfo.purchaseCount() + "개를 구매했습니다.");


        for(LottoTicket ticket : purchaseInfo.getTickets()) {
        }
    }
}
