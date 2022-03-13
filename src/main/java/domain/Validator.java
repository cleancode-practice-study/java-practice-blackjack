package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";
    public static final String TIE = "무";

    // 유저의 승패결과 구하는 메서드
    public static Map<String, String> getUserWinOrLoseResult(Player dealer, List<Player> users) {
        Map<String, String> userWinOrLoseResult = new HashMap<>();

        for (Player user : users) {
            checkUserWin(userWinOrLoseResult, dealer, user);
            checkUserLose(userWinOrLoseResult, dealer, user);
            checkUserTie(userWinOrLoseResult, dealer, user);
        }

        return userWinOrLoseResult;
    }

    private static void checkUserWin(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && isLargerThanDealerNumber(dealer, user)) || isValidUserNumber(dealer, user))
            userWinOrLoseResult.put(userName, WIN);
    }

    private static void checkUserLose(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && !isLargerThanDealerNumber(dealer, user)) || isValidDealerNumber(dealer, user))
            userWinOrLoseResult.put(userName, LOSE);
    }

    private static void checkUserTie(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && isEqualUserNumberAndDealerNumber(dealer, user)) || isNotValidDealerAndUserNumber(dealer, user))
            userWinOrLoseResult.put(userName, TIE);
    }

    private static boolean isValidDealerAndUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return isValidDealerResult && isValidUserResult;
    }

    private static boolean isNotValidDealerAndUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return !isValidDealerResult && !isValidUserResult;
    }

    private static boolean isValidUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return !isValidDealerResult && isValidUserResult;
    }

    private static boolean isValidDealerNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return isValidDealerResult && !isValidUserResult;
    }

    private static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return ResultStatistics.getCardTotalSum(dealer.cards) < ResultStatistics.getCardTotalSum(user.cards);
    }

    private static boolean isEqualUserNumberAndDealerNumber(Player dealer, Player user) {
        return ResultStatistics.getCardTotalSum(dealer.cards) == ResultStatistics.getCardTotalSum(user.cards);
    }

    private static boolean isValidPlayerNumber(Player player) {
        return ResultStatistics.getCardTotalSum(player.cards) <= STANDARD_NUMBER;
    }
}
