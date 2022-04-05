package view;

import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANT_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String ADDITION_CARD_INPUT_MESSAGE = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)\n";
    private static final String INPUT_ADDITIONAL_CARD_ERROR_MESSAGE = "y 혹은 n로 입력해주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getParticipantNames() {
        System.out.println(PARTICIPANT_INPUT_MESSAGE);
        return scanner.next();
    }

    public static String canGetAdditionCard(String name) {
        System.out.printf(ADDITION_CARD_INPUT_MESSAGE, name);
        return scanner.next();
    }
}
