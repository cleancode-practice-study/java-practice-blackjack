package controller;

import domain.Card;
import domain.Player;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public void play() {
        String names = InputView.inputPlayerNames(); // 게임의 참여할 사람 이름 입력 받기
        String[] players = Player.splitPlayerNames(names); // , 기준으로 잘라서 배열에 저장
        createInitialCard(players); // 각 player에게 2장의 카드 부여
    }

    private void createInitialCard(String[] players) {
        for (String name : players) {
            getInitialCard(name);
        }
    }

    private void getInitialCard(String player) {
        List<String> cards = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Card.getRandomCard();
        }
    }


}
