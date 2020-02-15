package lotto;

import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.prize.LottoPrize;
import lotto.prize.LottoPrizes;
import lotto.ticket.LottoTicket;
import lotto.ticket.WinningLottoTicket;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleLotto {
    private static final String SPLIT = ",";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        showEnterPaymentStatement();
        int payment = scanner.nextInt();
        scanner.nextLine();

        Lotto lotto = Lotto.buy(payment);
        showPurchaseInfo(lotto.purchaseInfo());

        showEnterWinningNumberStatement();
        String winningNumberString = scanner.nextLine();

        MatchResult matchResult = lotto.winningCheck(new WinningLottoTicket(convertToNumber(winningNumberString)));
        showResult(matchResult);
    }

    private static void showResult(MatchResult matchResult) {
        LottoPrizes prizes = matchResult.getPrizes();
        List<LottoPrize> lottoPrizes = Arrays.asList(LottoPrize.values());
        Collections.reverse(lottoPrizes);
        lottoPrizes.remove(0);

        int revenue = 0;
        for(LottoPrize lottoPrize : lottoPrizes) {
            System.out.println(lottoPrize.getMatchCount() + "개 일치 (" + lottoPrize.getPrizeMoney() + "원)- " + prizes.countOfPrize(lottoPrize) + "개");
            revenue += lottoPrize.getPrizeMoney() * prizes.countOfPrize(lottoPrize);
        }

        System.out.println("총 수익률은 " + revenue / matchResult.getPayment() + "%입니다.");
    }

    private static void showEnterPaymentStatement() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    private static void showEnterWinningNumberStatement() {
        System.out.println("지난 주 당첨 번호를 임력해 주세요.");
    }

    private static void showPurchaseInfo(PurchaseInfo purchaseInfo) {
        System.out.println(purchaseInfo.purchaseCount() + "개를 구매했습니다.");

        for(LottoTicket ticket : purchaseInfo.getTickets()) {
            System.out.println(ticket.getNumbers());
        }
    }

    private static List<Integer> convertToNumber(String winningNumberString) {
        return Arrays.stream(winningNumberString.split(SPLIT))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
