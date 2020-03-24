package lotto;

import lotto.dto.MatchResult;
import lotto.dto.PurchaseInfo;
import lotto.prize.LottoPrize;
import lotto.prize.LottoPrizes;
import lotto.ticket.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConsoleOutput {

    public static void showBoughtLottos(PurchaseInfo purchaseInfo) {
        System.out.printf("수동으로 %d, 자동으로 %d장 구매했습니다.\n", purchaseInfo.getManualTicketCount(), purchaseInfo.getAutoTicketCount());

        for(LottoTicket ticket : purchaseInfo.getTickets()) {
            System.out.println(ticket.getNumbers());
        }
    }

    public static void showMatchResult(MatchResult matchResult) {
        LottoPrizes prizes = matchResult.getPrizes();
        List<LottoPrize> lottoPrizes = new ArrayList<>(Arrays.asList(LottoPrize.values()));//https://kkwonsy.tistory.com/14
        Collections.reverse(lottoPrizes);
        lottoPrizes.remove(0);

        int revenue = 0;
        for(LottoPrize lottoPrize : lottoPrizes) {
            System.out.printf(
                    "%d개 %s일치(%d원)- %d개\n",
                    lottoPrize.getMatchCount(),
                    lottoPrize.isBonusMatching() ? ", 보너스 볼 " : "",
                    lottoPrize.getPrizeMoney(),
                    prizes.countOfPrize(lottoPrize)
            );
            revenue += lottoPrize.getPrizeMoney() * prizes.countOfPrize(lottoPrize);
        }

        System.out.printf("총 수익률은 %d%%입니다.\n", revenue / matchResult.getPayment());
    }

    public static List<String> getLottoPrizesResultString(MatchResult matchResult) {
        LottoPrizes prizes = matchResult.getPrizes();
        List<LottoPrize> lottoPrizes = new ArrayList<>(Arrays.asList(LottoPrize.values()));//https://kkwonsy.tistory.com/14
        Collections.reverse(lottoPrizes);
        lottoPrizes.remove(0);
        List<String> resultString = new ArrayList<>();

        for(LottoPrize lottoPrize : lottoPrizes) {
            resultString.add(
                    String.format(
                        "%d개 %s일치(%d원)- %d개\n",
                        lottoPrize.getMatchCount(),
                        lottoPrize.isBonusMatching() ? ", 보너스 볼 " : "",
                        lottoPrize.getPrizeMoney(),
                        prizes.countOfPrize(lottoPrize)
                ));
        }

        return resultString;
    }

    public static int getRevenue(MatchResult matchResult) {
        LottoPrizes prizes = matchResult.getPrizes();
        List<LottoPrize> lottoPrizes = new ArrayList<>(Arrays.asList(LottoPrize.values()));//https://kkwonsy.tistory.com/14
        Collections.reverse(lottoPrizes);
        lottoPrizes.remove(0);

        int revenue = 0;
        for(LottoPrize lottoPrize : lottoPrizes) {
            revenue += lottoPrize.getPrizeMoney() * prizes.countOfPrize(lottoPrize);
        }

        System.out.printf("총 수익률은 %d%%입니다.\n", revenue / matchResult.getPayment());
        return revenue / matchResult.getPayment();
    }
}
