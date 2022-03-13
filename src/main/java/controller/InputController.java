package controller;

import domain.Convert;
import domain.Player;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    public static final String NO = "n";

    static List<String> getUserNames() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] userNames = Convert.splitNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        System.out.println("");

        return new ArrayList<>(Arrays.asList(userNames));
    }

    public static boolean isNoUserAnswer(Player user) {
        String userName = user.name;
        String answer = InputView.inputYesOrNoOneCard(userName);

        return answer.equals(NO);
    }
}
