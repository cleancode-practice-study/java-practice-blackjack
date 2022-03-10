package controller;

import domain.Player;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    public void play() {
        List<String> players = getPlayers();
        List<Player> playersCards = createPlayersCards(players);
        OutputView.printPlayerCardTotalResult(playersCards);
    }

    private List<String> getPlayers() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] users = Player.splitPlayerNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        List<String> players = new ArrayList<>(Arrays.asList(users)); // 배열을 리스트로
        players.add(0, "딜러"); // 맨 앞에 딜러 추가

        return players;
    }

    private List<Player> createPlayersCards(List<String> players) {
        List<Player> playersCards = new ArrayList<>();

        OutputView.printPlayerInitialMessage(players); // 안내 메세지 출력

        for (String name : players) {
            Player player = Player.createPlayerCard(name);
            OutputView.printPlayerOwnCard(player); // 생성된 카드 출력
            playersCards.add(player);
            System.out.println("");
        }

        return playersCards;
    }


}
