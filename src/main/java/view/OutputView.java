package view;

import domain.Player;

public class OutputView {
    public static final String GET_DEALER_ONE_CARD_INFORMATION_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";

    public void printPlayerInitialMessage(String[] names) {
        System.out.println("딜러와 " + names[0] + ", " + names[1] + "에게 2장의 카드를 나누었습니다.");
    }

    public void printPlayerOwnCard(Player player) {
        System.out.println(player.name + " 카드 : " + player.card);
    }

    public void printDealerOneCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_INFORMATION_MESSAGE);
    }

    public void printPlayerCardTotalResult(Player player) {
        System.out.println(player.name + " 카드 : " + player.card + " - 결과 : " + player.getCardTotalSumResult());
    }

    public void printGameResult() {

    }
}
