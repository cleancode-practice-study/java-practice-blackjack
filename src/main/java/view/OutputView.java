package view;

//딜러와 halim, jinhee에게 2장의 카드를 나누었습니다.
//        딜러 카드: 3다이아몬드, 9클로버
//        halim 카드: 2하트, 8스페이드
//        jinhee 카드: 7클로버, K스페이드

public class OutputView {
    private static final String INIT_CARD_SETTING_OUTPUT_MESSAGE = "%s와 %s에게 2장의 카드를 나누었습니다.\n";
    private static final String ADDITIONAL_CARD_OUTPUT_MESSAGE = "딜러는 16이하라 한장의 카드를 더 받았습니다.\n";

    public static void printInitCardSetting(String participantNames, String dealerName) {
        System.out.println();
        System.out.printf(INIT_CARD_SETTING_OUTPUT_MESSAGE, dealerName, participantNames);
    }

    public static void printReceiveCardState(String cardState) {
        System.out.println(cardState);
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printAdditionalCard() {
        System.out.println(ADDITIONAL_CARD_OUTPUT_MESSAGE);
    }
}
