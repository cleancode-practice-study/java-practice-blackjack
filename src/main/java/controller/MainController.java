package controller;

import domain.Player;
import view.InputView;
import view.OutputView;

import java.util.List;


public class MainController {
    public void play() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] players = Player.splitPlayerNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        OutputView.printPlayerInitialMessage(players); // 메세지 출력
        for (String name : players) {
            List<String> cards = Player.getCard(); // player의 2장의 카드를 담은 list
            Player player = new Player(name, cards);
            OutputView.printPlayerOwnCard(player);
        }
    }


}
