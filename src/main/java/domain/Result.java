package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private static final int ONE = 1;
    private static final int TEN = 10;
    private static final int ELEVEN = 11;
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
    public static int getResultNumber(List<String> cards) {
        int sum = 0;

        for (String card : cards) {
            char number = card.charAt(0);

            if (Validator.isMinAceNumber(number, sum)) {
                sum += ONE;
                continue;
            }

            if (Validator.isMaxAceNumber(number, sum)) {
                sum += ELEVEN;
                continue;
            }

            if (Validator.isTenNumber(number)) {
                sum += TEN;
                continue;
            }

            sum += Character.getNumericValue(number);
        }

        return sum;
    }

    // 유저의 승패결과 구하는 메서드
    public static Map<String, String> getUserWinOrLoseResult(Player dealer, List<Player> users) {
        Map<String, String> userWinOrLoseResult = new HashMap<>();

        for (Player user : users) {
            Validator.checkUserWin(userWinOrLoseResult, dealer, user);
            Validator.checkUserLose(userWinOrLoseResult, dealer, user);
            Validator.checkUserTie(userWinOrLoseResult, dealer, user);
        }

        return userWinOrLoseResult;
    }
}
