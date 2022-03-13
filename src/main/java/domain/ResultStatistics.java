package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ResultStatistics {
    public static final int SPECIAL_NUMBER = 10;
    public static final int WIN_STANDARD_NUMBER = 21;
    public static final int MIN_ACE_NUMBER = 1;
    public static final char ACE = 'A';
    public static final char JACK = 'J';
    public static final char QUEEN = 'Q';
    public static final char KING = 'K';
    private static final String WIN = "승";
    private static final String LOSE = "패";

    // 딜러 승패 결과 구하는 메서드
    public static List<Integer> getDealerWinOrLoseResult(Map<String, String> map) {
        int winCount = 0;
        int loseCount = 0;
        int tieCount = 0;

        for (Map.Entry<String, String> value : map.entrySet()) {
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

    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public static int getCardTotalSum(List<String> cards) {
        int sum = 0;

        for (String card : cards) {
            char number = card.charAt(0);

            if (isAddMinAceNumber(number, sum)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (isAddSpecialNumber(number, sum)) {
                sum += SPECIAL_NUMBER;
                continue;
            }

            sum += Character.getNumericValue(number);
        }

        return sum;
    }

    private static boolean isAddSpecialNumber(char number, int sum) {
        return isAceCard(number) && isSmallThanWinStandardNumber(number, sum) || isJackAndQueenAndKingCards(number);
    }

    private static boolean isAddMinAceNumber(char number, int sum) {
        return isAceCard(number) && sum + SPECIAL_NUMBER > WIN_STANDARD_NUMBER;
    }

    private static boolean isJackAndQueenAndKingCards(char number) {
        return isJackCard(number) || isQueenCard(number) || isKingCard(number);
    }

    private static boolean isSmallThanWinStandardNumber(char number, int sum) {
        return sum + SPECIAL_NUMBER < WIN_STANDARD_NUMBER;
    }

    private static boolean isAceCard(char number) {
        return number == ACE;
    }

    private static boolean isJackCard(char number) {
        return number == JACK;
    }

    private static boolean isQueenCard(char number) {
        return number == QUEEN;
    }

    private static boolean isKingCard(char number) {
        return number == KING;
    }

}
