package controller;

import domain.Player;
import util.RandomCard;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {

    public static final int GET_ONE_MORE_CARD_STANDARD_NUMBER = 16;

    public void play() {
        List<String> names = getPlayerNames();
        List<Player> players = getPlayers(names);
        List<Player> users = players.subList(1, players.size());
        checkOneMoreCard(users); // 사용자 한장 더 받을지
        checkDealerOneMoreCar(players.get(0)); // 딜러 한장 더 받을지
        OutputView.printPlayerCardTotalResult(players);
    }

    private void checkDealerOneMoreCar(Player player) {
        if (player.getCardTotalSum() < GET_ONE_MORE_CARD_STANDARD_NUMBER) {
            player.cards.add(RandomCard.getRandomCard());
            OutputView.printDealerOneCardMessage();
            System.out.println("");
        }
    }

    private List<String> getPlayerNames() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] users = Player.splitPlayerNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        List<String> players = new ArrayList<>(Arrays.asList(users)); // 배열을 리스트로
        players.add(0, "딜러"); // 맨 앞에 딜러 추가

        return players;
    }

    private List<Player> getPlayers(List<String> players) {
        List<Player> playersCards = new ArrayList<>();

        OutputView.printPlayerInitialMessage(players); // 안내 메세지 출력

        for (String name : players) {
            List<String> cards = Player.getCard(); // player의 2장의 카드를 담은 list
            Player player = Player.createPlayer(name, cards);
            OutputView.printPlayerOwnCard(player); // 생성된 카드 출력
            playersCards.add(player);
            System.out.println("");
        }

        return playersCards;
    }

    private void checkOneMoreCard(List<Player> users) {
        for (Player user : users) {
            boolean check = true;
            String choice;

            while (check) {
                choice = InputView.inputYesOrNoOneCard(user.name);

                if (choice.equals("y"))
                    user.cards.add(RandomCard.getRandomCard());
                else
                    check = false;

                OutputView.printPlayerOwnCard(user);
                System.out.println("");
            }
        }
        System.out.println("");
    }


}
