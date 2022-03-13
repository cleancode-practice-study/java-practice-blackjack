package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";
    public static final String TIE = "무";

    // 수정 필요 > indent2
    // 유저의 승패결과 구하는 메서드
    public static Map<String, String> getUserWinOrLoseResult(Player dealer, List<Player> users) {
        Map<String, String> userWinOrLoseResult = new HashMap<>();

        for (Player user : users) {
            if (isValidPlayNumber(dealer, user) && isLargerThanDealerNumber(dealer, user)) { // 유저 딜러 true, 유저 > 딜러
                userWinOrLoseResult.put(user.name, WIN);
                continue;
            } else if (isEqualUserAndDealer(dealer, user)) {
                userWinOrLoseResult.put(user.name, TIE);
            }

            userWinOrLoseResult.put(user.name, LOSE);
        }

        return userWinOrLoseResult;
    }

    private static boolean isValidPlayNumber(Player dealer, Player user) {
        boolean isValidUserResult = isValidPlayerCardResultNumber(user);
        boolean isValidDealerResult = isValidPlayerCardResultNumber(dealer);

        return isValidDealerResult && isValidUserResult;
    }

    private static boolean isEqualUserAndDealer(Player dealer, Player user) {
        return ResultStatistics.getCardTotalSum(dealer.cards) == ResultStatistics.getCardTotalSum(user.cards);
    }

    private static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return ResultStatistics.getCardTotalSum(dealer.cards) < ResultStatistics.getCardTotalSum(user.cards);
    }

    private static boolean isValidPlayerCardResultNumber(Player player) {
        return ResultStatistics.getCardTotalSum(player.cards) <= WIN_STANDARD_NUMBER;
    }
}
