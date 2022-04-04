package view;

import domain.CardState;
import domain.DealerGameResult;
import domain.Participants;

import java.util.List;

public class OutputView {
    private static final String INPUT_NAMES_ERROR_MESSAGE = "[ERROR] 쉼표를 포함하여 올바르게 입력해주십시오.";
    private static final String INIT_CARD_SETTING_OUTPUT_MESSAGE = "%s와 %s에게 2장의 카드를 나누었습니다.\n";
    private static final String ADDITIONAL_CARD_OUTPUT_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String CURRENT_CARD_STATE_OUTPUT_MESSAGE = "%s 카드: %s\n";
    private static final String FINAL_CARD_STATE_OUTPUT_MESSAGE = "%s 카드: %s - 결과: %d\n";
    private static final String FINAL_GAME_RESULT_GUIDE_OUTPUT_MESSAGE = "## 최종 승패";
    private static final String FINAL_GAME_RESULT_OUTPUT_MESSAGE = "%s: %s\n";

    public static void printInputNamesErrorMessage() {
        System.out.println(INPUT_NAMES_ERROR_MESSAGE);
    }

    public static void printInitCardSetting(Participants participants, String dealerName) {
        System.out.println();
        String participantNames = String.join(", ", participants.getParticipantNames());
        System.out.printf(INIT_CARD_SETTING_OUTPUT_MESSAGE, dealerName, participantNames);
    }

    public static void printReceiveCardState(String name, CardState cardState) {
        System.out.printf(CURRENT_CARD_STATE_OUTPUT_MESSAGE, name, String.join(", ", cardState.getCardState()));
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printAdditionalCard() {
        System.out.println(ADDITIONAL_CARD_OUTPUT_MESSAGE);
    }

    public static void printCardFinalState(String name, CardState cardState, int cardSum) {
        System.out.printf(FINAL_CARD_STATE_OUTPUT_MESSAGE, name, String.join(", ", cardState.getCardState()), cardSum);
    }

    public static void printFinalResult() {
        printLine();
        System.out.println(FINAL_GAME_RESULT_GUIDE_OUTPUT_MESSAGE);
    }

    public static void printFinalDealerResult(String name, DealerGameResult dealerGameResult) {
        List<String> dealerResult = dealerGameResult.getResultForPrint();
        System.out.printf(FINAL_GAME_RESULT_OUTPUT_MESSAGE, name, String.join(" ", dealerResult));
    }

    public static void printFinalParticipantResult(String name, String result) {
        System.out.printf(FINAL_GAME_RESULT_OUTPUT_MESSAGE, name, result);
    }
}
