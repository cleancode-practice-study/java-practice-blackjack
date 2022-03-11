package domain;

import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";

    // 딜러와 플레이어의 카드 숫자 합 비교
    public static void compareDealerAndUser(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerCardSumNumber(dealer);
        boolean isValidUserResult = isValidPlayerCardSumNumber(user);

        // 수정 필요 - indent 2개
        if (isValidDealerResult && isValidUserResult || !isValidDealerResult && isValidUserResult) { // 딜러 유저 true
            if (isWinUser(dealer, user))
                userWinOrLoseResult.put(user.name, WIN);
            return;
        }

        userWinOrLoseResult.put(user.name, LOSE);
    }

    private static boolean isWinUser(Player dealer, Player user) {
        return dealer.getCardTotalSum() < user.getCardTotalSum();
    }

    private static boolean isValidPlayerCardSumNumber(Player player) {
        boolean isValidDealerTotalSumNumber = true;

        if (player.getCardTotalSum() > WIN_STANDARD_NUMBER)
            isValidDealerTotalSumNumber = false;

        return isValidDealerTotalSumNumber;
    }
}
