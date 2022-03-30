package view;

import model.Participant;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private static final String INIT_CARD_SETTING_OUTPUT_MESSAGE = "%s와 %s에게 2장의 카드를 나누었습니다.\n";
    private static final String ADDITIONAL_CARD_OUTPUT_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.\n";
    private static final String CURRENT_CARD_STATE_OUTPUT_MESSAGE = "%s 카드: %s\n";
    private static final String FINAL_CARD_STATE_OUTPUT_MESSAGE = "%s 카드: %s - 결과: %d\n";
    private static final String FINAL_GAME_RESULT_GUIDE_OUTPUT_MESSAGE = "## 최종 승패";
    private static final String FINAL_GAME_RESULT_OUTPUT_MESSAGE = "%s: %s\n";

    public static void printInitCardSetting(List<Participant> participants, String dealerName) {
        System.out.println();
        String participantNames = getParticipantEachNames(participants);
        System.out.printf(INIT_CARD_SETTING_OUTPUT_MESSAGE, dealerName, participantNames);
    }
    private static String getParticipantEachNames(List<Participant> participants) {
        List<String> participantNames = new ArrayList<>();

        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }

        return String.join(", ", participantNames);
    }

    public static void printReceiveCardState(String name, List<String> cardState) {
        System.out.printf(CURRENT_CARD_STATE_OUTPUT_MESSAGE, name, String.join(", ", cardState));
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printAdditionalCard() {
        System.out.println(ADDITIONAL_CARD_OUTPUT_MESSAGE);
    }

    public static void printCardFinalState(String name, List<String> cards, int cardSum) {
        System.out.printf(FINAL_CARD_STATE_OUTPUT_MESSAGE, name, String.join(", ", cards), cardSum);
    }

    public static void printFinalResult() {
        printLine();
        System.out.println(FINAL_GAME_RESULT_GUIDE_OUTPUT_MESSAGE);
    }

    public static void printFinalDealerResult(String name, List<String> dealerResult) {
        System.out.printf(FINAL_GAME_RESULT_OUTPUT_MESSAGE, name, String.join(" ", dealerResult));
    }

    public static void printFinalParticipantResult(String name, String result) {
        System.out.printf(FINAL_GAME_RESULT_OUTPUT_MESSAGE, name, result);
    }



}
