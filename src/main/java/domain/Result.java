package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int MIN_ACE_NUMBER = 1;
    private static final int TEN = 10;
    private static final int MAX_ACE_NUMBER = 11;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String TIE = "무";

    // 딜러 승패 결과 구하는 메서드
    public static Map<String, Integer> getDealerResult(Map<String, String> userResult) {
        Map<String, Integer> dealerResult = new HashMap<String, Integer>() {
            {
                put(WIN, 0);
                put(LOSE, 0);
                put(TIE, 0);
            }
        };

        List<String> result = new ArrayList<>();
        for (String userName : userResult.keySet())
            result.add(userResult.get(userName));

        for (String str : result)
            dealerResult.put(str, dealerResult.getOrDefault(str, 0) + 1);

        return dealerResult;
    }

    // 카드 숫자 합계 반환 메서드
    public static int getSumNumber(List<String> cards) {
        int sum = 0;

        for (String card : cards) {
            char number = card.charAt(0);

            if (Card.isMinAceNumber(number, sum)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (Card.isMaxAceNumber(number, sum)) {
                sum += MAX_ACE_NUMBER;
                continue;
            }

            if (Card.isJackAndQueenAndKingCard(number)) {
                sum += TEN;
                continue;
            }

            sum += Character.getNumericValue(number);
        }

        return sum;
    }

    // 유저의 승패결과 구하는 메서드
    public static Map<String, String> getUserResult(Player dealer, List<Player> users) {
        Map<String, String> userResult = new HashMap<>();

        for (Player user : users)
            checkUserResult(userResult, dealer, user);

        return userResult;
    }

    public static void checkUserResult(Map<String, String> userResult, Player dealer, Player user) {
        checkUserWin(userResult, dealer, user);
        checkUserLose(userResult, dealer, user);
        checkUserTie(userResult, dealer, user);
    }

    public static void checkUserWin(Map<String, String> userResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidUserNumber(dealer, user))
            userResult.put(userName, WIN);
    }

    public static void checkUserLose(Map<String, String> userResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && !Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidDealerNumber(dealer, user))
            userResult.put(userName, LOSE);
    }

    public static void checkUserTie(Map<String, String> userResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isEqualUserNumberAndDealerNumber(dealer, user)) || Player.isNotValidDealerAndUserNumber(dealer, user))
            userResult.put(userName, TIE);
    }


}
