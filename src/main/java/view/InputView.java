package view;

import java.util.Scanner;

public class InputView {
    private static final String PARTICIPANT_INPUT_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";

    private static final Scanner scanner = new Scanner(System.in);

    public static String getParticipantInputMessage() {
        System.out.println(PARTICIPANT_INPUT_MESSAGE);
        return scanner.next();
    }
}
