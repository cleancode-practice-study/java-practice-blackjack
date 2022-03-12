package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";

    // 수정 필요 > indent2 , else
    // 딜러와 플레이어의 카드 숫자 합 비교
    public static Map<String, String> getUserWinOrLoseResult(Player dealer, List<Player> users) {
        Map<String, String> userWinOrLoseResult = new HashMap<>();

        for (Player user : users) {
            if (isWinnerUser(dealer, user)) {
                userWinOrLoseResult.put(user.name, WIN);
            } else
                userWinOrLoseResult.put(user.name, LOSE);
        }

        return userWinOrLoseResult;
    }


    private static boolean isWinnerUser(Player dealer, Player user) {
        boolean isValidUserResult = isValidPlayerCardResultNumber(user);

        if (isValidUserResult) // 유저 true
            return isLargerThanDealerNumber(dealer, user);

        return false;
    }

    private static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerCardResultNumber(dealer);

        if (isValidDealerResult) // 딜러 true
            return dealer.getCardTotalSum() < user.getCardTotalSum();

        return true;
    }

    private static boolean isValidPlayerCardResultNumber(Player player) {
        return player.getCardTotalSum() <= WIN_STANDARD_NUMBER;
    }
}
