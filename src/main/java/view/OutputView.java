package view;

import domain.Player;

import java.util.List;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public static void printPlayerInitialMessage(List<String> names) {
        System.out.println("딜러와 " + names.get(1) + ", " + names.get(2) + "에게 2장의 카드를 나누었습니다.");
    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.name + " 카드 : " + player.cards);
    }

    public static void printDealerOneCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public static void printPlayerCardTotalResult(List<Player> players) {
        for (Player player : players) {
            printPlayerOwnCard(player);
            System.out.println(" - 결과 : " + player.getCardTotalSum());
        }
    }

    public void printGameResult() {

    }
}
