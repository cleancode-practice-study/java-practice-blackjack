package view;

import domain.Player;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    public static final String GIVE_A_PLAYER_2_CARDS_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    public static final String RESULT_MESSAGE = " - 결과 : ";
    public static final String DEALER = "딜러와 ";
    public static final String COLON_SYMBOL = " : ";
    public static final String CARD = " 카드 : ";
    public static final String WIN = "승 ";
    public static final String LOSE = "패 ";
    public static final String TIE = "무";
    public static final String FINAL_WIN_OR_LOSE_RESULT_MESSAGE = "## 최종 승패";
    public static final int WIN_COUNT_INDEX = 0;
    public static final int LOSE_COUNT_INDEX = 1;
    public static final int TIE_COUNT_INDEX = 2;

    public static void printPlayerInitialMessage(String addCommaString) {
        System.out.print(DEALER + addCommaString + GIVE_A_PLAYER_2_CARDS_MESSAGE);
    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.name + CARD + player.cards);
    }

    public static void printPlayerCardTotalResult(Player player, int result) {
        printPlayerOwnCard(player);
        System.out.println(RESULT_MESSAGE + result);
    }

    public static void printDealerOneMoreCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public static void printUsersWinOrLoseResult(Map<String, String> map) {
        for (Map.Entry<String, String> entrySet : map.entrySet())
            System.out.println(entrySet.getKey() + COLON_SYMBOL + entrySet.getValue());
    }

    public static void printDealerWinOrLoseResult(List<Integer> dealerCount) {
        int winCount = dealerCount.get(WIN_COUNT_INDEX);
        int loseCount = dealerCount.get(LOSE_COUNT_INDEX);
        int tieCount = dealerCount.get(TIE_COUNT_INDEX);

        System.out.println(FINAL_WIN_OR_LOSE_RESULT_MESSAGE);
        System.out.println(DEALER + COLON_SYMBOL + winCount + WIN + loseCount + LOSE + tieCount + TIE);
    }
}
