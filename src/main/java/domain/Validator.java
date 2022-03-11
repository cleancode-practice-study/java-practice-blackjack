package domain;

import java.util.List;

public class Validator {
    private static final int WIN_STANDARD_NUMBER = 21;

    // 딜러와 플레이어의 카드 숫자 합 비교
    public static int compareDealerAndUser(Player dealer, List<Player> users) {
        boolean isValidUserResult = checkValidUsersTotalSumNumber(users);
        boolean isValidDealerResult = checkValidDealerTotalSumNumber(dealer);
        int winCount = 0;

        if (isValidDealerResult)
            if (isValidUserResult && dealer.getCardTotalSum() > users.get(0).getCardTotalSum()) {
                winCount++;
            } else if (!isValidUserResult) {
                winCount++;
            }

        return winCount;
    }

    private static boolean checkValidDealerTotalSumNumber(Player dealer) {
        boolean isValidDealerTotalSumNumber = true;

        if (dealer.getCardTotalSum() > WIN_STANDARD_NUMBER)
            isValidDealerTotalSumNumber = false;

        return isValidDealerTotalSumNumber;
    }

    private static boolean checkValidUsersTotalSumNumber(List<Player> users) {
        boolean isValidUsersTotalSumNumber = true;

        for (Player user : users) {
            if (user.getCardTotalSum() > WIN_STANDARD_NUMBER)
                isValidUsersTotalSumNumber = false;
        }

        return isValidUsersTotalSumNumber;
    }
}
