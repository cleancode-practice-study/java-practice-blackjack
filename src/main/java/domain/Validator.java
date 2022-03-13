package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";
    public static final String TIE = "무";

    // 유저의 승패결과 구하는 메서드
    public static Map<String, String> getUserWinOrLoseResult(Player dealer, List<Player> users) {
        Map<String, String> userWinOrLoseResult = new HashMap<>();
        boolean isValidDealerResult = isValidPlayerCardResultNumber(dealer);

        for (Player user : users) {
            boolean isValidUserResult = isValidPlayerCardResultNumber(user);

            if (isValidUserResult && isValidDealerResult) { // 유저 딜러 true 인경우
                if (isLargerThanDealerNumber(dealer, user)) { // 유저 > 딜러
                    userWinOrLoseResult.put(user.name, WIN);
                } else if (!isLargerThanDealerNumber(dealer, user)) { //  유저 < 딜러
                    userWinOrLoseResult.put(user.name, LOSE);
                } else { // 유저 == 딜러
                    userWinOrLoseResult.put(user.name, TIE);
                }
            } else if (!isValidUserResult && isValidDealerResult) {
                userWinOrLoseResult.put(user.name, LOSE);
            } else if (isValidUserResult) {
                userWinOrLoseResult.put(user.name, WIN);
            } else {
                userWinOrLoseResult.put(user.name, TIE);
            }
        }

        return userWinOrLoseResult;
    }

    private static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return ResultStatistics.getCardTotalSum(dealer.cards) < ResultStatistics.getCardTotalSum(user.cards);
    }

    private static boolean isValidPlayerCardResultNumber(Player player) {
        return ResultStatistics.getCardTotalSum(player.cards) <= WIN_STANDARD_NUMBER;
    }
}
