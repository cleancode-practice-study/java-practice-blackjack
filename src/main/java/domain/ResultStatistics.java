package domain;

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
    private static final String LOSE = "패";

    // 수정 필요 - indent 2개
    // 딜러 win count 구하는 메서드
    public static int getDealerWinCounter(Map<String, String> map) {
        int winCount = 0;

        for (Map.Entry<String, String> value : map.entrySet()) {
            if (value.getValue().equals(LOSE))
                winCount++;
        }

        return winCount;
    }

    // 수정 필요 - indent 2개
    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public static int getCardTotalSum(List<String> cards) {
        int sum = 0;

        for (String card : cards) {
            if (isAddMinAceNumber(card, sum)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (isAddSpecialNumber(card, sum)) {
                sum += SPECIAL_NUMBER;
                continue;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }

    private static boolean isAddSpecialNumber(String card, int sum) {
        return isAceCard(card) && isSmallThanWinStandardNumber(card, sum) || isJackAndQueenAndKingCards(card);
    }

    private static boolean isAddMinAceNumber(String card, int sum) {
        return card.charAt(0) == ACE && sum + SPECIAL_NUMBER > WIN_STANDARD_NUMBER;
    }

    private static boolean isJackAndQueenAndKingCards(String card) {
        return card.charAt(0) == JACK || card.charAt(0) == QUEEN || card.charAt(0) == KING;
    }

    private static boolean isAceCard(String card) {
        return card.charAt(0) == ACE;
    }

    private static boolean isSmallThanWinStandardNumber(String card, int sum) {
        return sum + SPECIAL_NUMBER < WIN_STANDARD_NUMBER;
    }
}
