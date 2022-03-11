package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;

    // 딜러와 플레이어의 카드 숫자 합 비교
    public static Map<String, String> compareDealerAndUser(Player dealer, List<Player> users) {
        boolean isValidDealerResult = isValidPlayerCardSumNumber(dealer);

        Map<String, String> map = new HashMap<>();

        for (Player user : users) {
            boolean isValidUserResult = isValidPlayerCardSumNumber(user);
            if (isValidDealerResult) { // 딜러 true
                if (isValidUserResult) { // 유저 true
                    if (dealer.getCardTotalSum() > user.getCardTotalSum())
                        map.put(user.name, "패");
                    else if (dealer.getCardTotalSum() < user.getCardTotalSum()) {
                        map.put(user.name, "승");
                    }
                } else { // 유저 false
                    map.put(user.name, "패");
                }
            } else { // 딜러 false
                if (isValidUserResult)
                    map.put(user.name, "승");
            }
        }

        return map;
    }

    private static boolean isValidPlayerCardSumNumber(Player player) {
        boolean isValidDealerTotalSumNumber = true;

        if (player.getCardTotalSum() > WIN_STANDARD_NUMBER)
            isValidDealerTotalSumNumber = false;

        return isValidDealerTotalSumNumber;
    }
}
