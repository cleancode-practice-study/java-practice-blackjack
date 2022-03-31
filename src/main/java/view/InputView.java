package view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYER_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요. (쉼표 기준으로 분리)";
    private static final String INPUT_YES_OR_NO_ONE_CARD = "은(는) 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)";
    static Scanner scanner = new Scanner(System.in);

    public static String inputPlayerNames() {
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);
        return scanner.next();
    }

    public static String inputYesOrNoOneCard(String name) {
        System.out.println(name + INPUT_YES_OR_NO_ONE_CARD);
        return scanner.next();
    }
}
