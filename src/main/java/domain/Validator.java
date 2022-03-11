package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;

    // 딜러와 플레이어의 카드 숫자 합 비교
    public static Map<String, String> compareDealerAndUser(Player dealer, List<Player> users) {
        boolean isValidUserResult = isValidUsersCardSumNumber(users);
        boolean isValidDealerResult = isValidDealerCardSumNumber(dealer);
        Map<String, String> map = new HashMap<>();

        for (Player user : users) {
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

    private static boolean isValidDealerCardSumNumber(Player dealer) {
        boolean isValidDealerTotalSumNumber = true;

        if (dealer.getCardTotalSum() > WIN_STANDARD_NUMBER)
            isValidDealerTotalSumNumber = false;

        return isValidDealerTotalSumNumber;
    }

    private static boolean isValidUsersCardSumNumber(List<Player> users) {
        boolean isValidUsersTotalSumNumber = true;

        for (Player user : users) {
            if (user.getCardTotalSum() > WIN_STANDARD_NUMBER)
                isValidUsersTotalSumNumber = false;
        }

        return isValidUsersTotalSumNumber;
    }
}
