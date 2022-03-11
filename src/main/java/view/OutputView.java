package view;

import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    public static final String RESULT_MESSAGE = " - 결과 : ";
    public static final String DEALER = "딜러";
    public static final String GIVE_A_PLAYER_2_CARDS_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    public static final String COLON_SYMBOL = " : ";
    public static final String CARD = " 카드 : ";
    public static final String COMMA_SYMBOL = " , ";
    public static final String WIN = "승 ";
    public static final String LOSE = "패";
    public static final String FINAL_WIN_OR_LOSE_RESULT_MESSAGE = "## 최종 승패";

    public static void printPlayerInitialMessage(List<Player> users) {
        List<String> names = new ArrayList<>();
        for (Player user : users)
            names.add(user.name);

        String addCommaString = String.join(", ", names);

        System.out.print(DEALER + "와 " + addCommaString + GIVE_A_PLAYER_2_CARDS_MESSAGE);

    }

    public static void printPlayerOwnCard(Player player) {
        System.out.print(player.name + CARD + player.cards);
    }

    public static void printDealerOneMoreCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public static void printPlayerCardTotalResult(Player player) {
        printPlayerOwnCard(player);
        System.out.println(RESULT_MESSAGE + player.getCardTotalSum());
    }

    public static void printUsersWinOrLoseResult(Map<String, String> map) {
        for (Map.Entry<String, String> entrySet : map.entrySet())
            System.out.println(entrySet.getKey() + COLON_SYMBOL + entrySet.getValue());
    }

    public static void printDealerWinOrLoseResult(int userSize, int dealerWinCount) {
        System.out.println(FINAL_WIN_OR_LOSE_RESULT_MESSAGE);
        System.out.println(DEALER + COLON_SYMBOL + dealerWinCount + WIN + (userSize - dealerWinCount) + LOSE);
    }
}
