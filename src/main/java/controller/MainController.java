package controller;

import domain.Player;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    public void play() {
        String[] users = getUsers();
        List<String> players = getPlayers(users);
        createPlayer(players);
    }

    public List<String> getPlayers(String[] users) {
        List<String> players = new ArrayList<>(Arrays.asList(users)); // 배열 리스트로
        players.add(0, "딜러"); // 딜러 추가

        return players;
    }

    public String[] getUsers() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] users = Player.splitPlayerNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장

        return users;
    }

    public void createPlayer(List<String> players) {
        OutputView.printPlayerInitialMessage(players); // 안내 메세지 출력
        for (String name : players) {
            Player player = createPlayerCard(name);
            OutputView.printPlayerOwnCard(player); // 생성된 카드 출력
        }
    }

    public Player createPlayerCard(String name) {
        List<String> cards = Player.getCard(); // player의 2장의 카드를 담은 list
        Player player = new Player(name, cards);

        return player;
    }


}
