package view;

import domain.Player;

import java.util.Map;

public class OutputView {
    private static final String GET_DEALER_ONE_CARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String GIVE_A_PLAYER_2_CARDS_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    private static final String FINAL_RESULT_MESSAGE = "## 최종 승패";
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String TIE = "무";

    public static void printPlayerInitialMessage(String fullNames) {
        System.out.print("딜러와 " + fullNames + GIVE_A_PLAYER_2_CARDS_MESSAGE);
    }

    public static void printDealerOneMoreCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_MESSAGE);
    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.getName() + " 카드 : " + player.getCards());
    }

    public static void printTotalPlayerResult(Player player, int result) {
        printPlayerOwnCard(player);
        System.out.println(" - 결과 : " + result);
    }

    public static void printUserResult(Map<String, String> userResult) {
        for (String userName : userResult.keySet())
            System.out.println(userName + " : " + userResult.get(userName));
    }

    public static void printDealerResult(Map<String, Integer> dealerResult) {
        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println("딜러 : " + dealerResult.get(LOSE) + WIN + " " + dealerResult.get(WIN) + LOSE + " " + dealerResult.get(TIE) + TIE);
    }
}
