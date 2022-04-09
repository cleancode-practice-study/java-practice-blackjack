package view;

import domain.Convert;
import domain.Player;
import domain.ResultTypes;

import java.util.Map;

public class OutputView {
    private static final String GET_DEALER_ONE_CARD_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String GIVE_A_PLAYER_2_CARDS_MESSAGE = "에게 2장의 카드를 나누었습니다.";
    private static final String FINAL_RESULT_MESSAGE = "## 최종 승패";
    private static final String WIN = ResultTypes.WIN.getResultType();
    private static final String LOSE = ResultTypes.LOSE.getResultType();
    private static final String TIE = ResultTypes.TIE.getResultType();

    public static void printPlayersInitialMessage(String names) {
        System.out.print("딜러와 " + names + GIVE_A_PLAYER_2_CARDS_MESSAGE);
    }

    public static void printDealerOneMoreCardMessage() {
        System.out.println(GET_DEALER_ONE_CARD_MESSAGE);
    }

    public static void printPlayerCards(Player player) {
        System.out.print(player.getName() + " 카드 : ");
        String cards = Convert.getCardsWithComma(player.getCards());
        System.out.print(cards);
    }

    public static void printPlayerCardsSumResult(Player player, int result) {
        printPlayerCards(player);
        System.out.println(" - 결과 : " + result);
    }

    public static void printParticipantsGameResult(Map<String, String> ParticipantsResult) {
        for (String userName : ParticipantsResult.keySet())
            System.out.println(userName + " : " + ParticipantsResult.get(userName));
    }

    public static void printDealerGameResult(Map<String, Integer> dealerResult) {
        String winCount = dealerResult.get(LOSE) + WIN;
        String loseCount = dealerResult.get(WIN) + LOSE;
        String tieCount = dealerResult.get(TIE) + TIE;

        System.out.println(FINAL_RESULT_MESSAGE);
        System.out.println("딜러 : " + winCount + " " + loseCount + " " + tieCount);
    }
}
