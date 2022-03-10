package view;

import domain.Player;

import java.util.List;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    public static final String RESULT_MESSAGE = " - 결과 : ";

    public static void printPlayerInitialMessage(List<String> names) {
        System.out.print(names.get(0) + "와 ");
        for (int i = 1; i < names.size(); i++)
            System.out.print(names.get(i).replaceAll("^[i != names.size() - 1]", names.get(i) + ", "));

        System.out.println("에게 2장의 카드를 나누었습니다.");
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
            System.out.println(RESULT_MESSAGE + player.getCardTotalSum());
        }
    }

    public void printGameResult() {

    }
}
