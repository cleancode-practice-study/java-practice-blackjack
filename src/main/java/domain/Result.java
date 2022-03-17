package domain;

import java.util.*;

public class Result {
    public static final int ONE = 1;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    private static final String WIN = "승";
    private static final String LOSE = "패";

    // 딜러 승패 결과 구하는 메서드
    public static List<Integer> getDealerWinOrLoseResult(Map<String, String> userResult) {
        int winCount = 0;
        int loseCount = 0;
        int tieCount = 0;

        for (Map.Entry<String, String> value : userResult.entrySet()) {
            String result = value.getValue();

            if (result.equals(LOSE))
                winCount++;
            else if (result.equals(WIN)) {
                loseCount++;
            } else {
                tieCount++;
            }
        }

        return new ArrayList<>(Arrays.asList(winCount, loseCount, tieCount));
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
