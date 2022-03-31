package view;

import domain.Player;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String GIVE_A_PLAYER_2_CARDS_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    private static final String CARD = " 카드 : ";
    private static final String WIN = "승 ";
    private static final String LOSE = "패 ";
    private static final String TIE = "무 ";
    private static final String FINAL_WIN_OR_LOSE_RESULT_MESSAGE = "## 최종 승패";
    private static final int WIN_COUNT_INDEX = 0;
    private static final int LOSE_COUNT_INDEX = 1;
    private static final int TIE_COUNT_INDEX = 2;

    public static void printPlayerInitialMessage(String fullNames) {
        System.out.print("딜러와 " + fullNames + GIVE_A_PLAYER_2_CARDS_MESSAGE);
    }

    public static void printDealerOneMoreCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.getName() + CARD + player.getCards());
    }

    public static void printTotalPlayerResult(Player player, int result) {
        printPlayerOwnCard(player);
        System.out.println(" - 결과 : " + result);
    }

    public static void printUsersWinOrLoseResult(Map<String, String> map) {
        for (Map.Entry<String, String> entrySet : map.entrySet())
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
    }

    public static void printDealerWinOrLoseResult(List<Integer> dealerCount) {
        int winCount = dealerCount.get(WIN_COUNT_INDEX);
        int loseCount = dealerCount.get(LOSE_COUNT_INDEX);
        int tieCount = dealerCount.get(TIE_COUNT_INDEX);

        System.out.println(FINAL_WIN_OR_LOSE_RESULT_MESSAGE);
        System.out.println("딜러 : " + winCount + WIN + loseCount + LOSE + tieCount + TIE);
    }
}
