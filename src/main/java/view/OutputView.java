package view;

import domain.Player;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    public static final String RESULT_MESSAGE = " - 결과 : ";
    public static final String DEALER = "딜러와 ";

    public static void printPlayerInitialMessage(List<String> names) {
        System.out.print(DEALER);
        for (int i = 0; i < names.size(); i++)
            System.out.print(names.get(i).replaceAll("^[i != names.size() - 1]", names.get(i) + ", "));

        System.out.println("에게 2장의 카드를 나누었습니다.");
    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.name + " 카드 : " + player.cards);
    }

    public static void printDealerOneCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public static void printPlayerCardTotalResult(Player player) {
        printPlayerOwnCard(player);
        System.out.println(RESULT_MESSAGE + player.getCardTotalSum());
    }

    public static void printUsersWinOrLoseResult(Map<String, String> map) {
        for (Map.Entry<String, String> entrySet : map.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
        }
    }

    public static void printGameResult() {

    }
}
