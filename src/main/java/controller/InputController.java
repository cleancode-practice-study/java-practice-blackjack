package controller;

import domain.Player;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    public static final String NO = "n";

    static List<String> getUserNames() {
        String name = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] names = Player.splitPlayerNames(name); // model 호출, 쉼표 기준으로 잘라서 배열에 저장

        return new ArrayList<>(Arrays.asList(names));
    }

    public static boolean isNoOneMoreCard(Player user) {
        String choice = InputView.inputYesOrNoOneCard(user.name);

        return choice.equals(NO);
    }
}
