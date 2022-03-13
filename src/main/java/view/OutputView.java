package view;

//딜러와 halim, jinhee에게 2장의 카드를 나누었습니다.
//        딜러 카드: 3다이아몬드, 9클로버
//        halim 카드: 2하트, 8스페이드
//        jinhee 카드: 7클로버, K스페이드

public class OutputView {
    private static final String INIT_CARD_SETTING_OUTPUT_MESSAGE = "%s와 %s에게 2장의 카드를 나누었습니다.\n";
    private static final String RECEIVED_CARD_OUTPUT_MESSAGE = "%s 카드: %s\n";

    public static void printInitCardSetting(String participantNames, String dealerName) {
        System.out.println();
        System.out.printf(INIT_CARD_SETTING_OUTPUT_MESSAGE, dealerName, participantNames);
    }

    public static void printParticipantReceiveCardState(String name, String cards) {
        System.out.printf(RECEIVED_CARD_OUTPUT_MESSAGE, name, cards);
    }

    public static void printDealerReceiveCardState(String name, String cards) {
        System.out.printf(RECEIVED_CARD_OUTPUT_MESSAGE, name, cards);
    }
}
