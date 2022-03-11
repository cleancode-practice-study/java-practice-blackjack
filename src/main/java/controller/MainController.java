package controller;

import domain.Player;
import domain.RandomCard;
import domain.Validator;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainController {
    public static final int DEALER_ONE_MORE_CARD_STANDARD_NUMBER = 16;

    public void play() {
        Player dealer = createDealer();
        List<Player> users = createUsers();
        System.out.println("");

        OutputView.printPlayerOwnCard(dealer);
        for (Player user : users)
            OutputView.printPlayerOwnCard(user);
        System.out.println("");

        printGameResult(dealer, users);
    }

    private Player createDealer() {
        List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
        return new Player("딜러", cards);
    }

    private List<Player> createUsers() {
        List<Player> players = new ArrayList<>();
        List<String> names = getUserNames();
        OutputView.printPlayerInitialMessage(names);

        for (String name : names) {
            List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
            Player player = new Player(name, cards);
            players.add(player);
        }

        return players;
    }

    private List<String> getUserNames() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] users = Player.splitPlayerNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        List<String> players = new ArrayList<>(Arrays.asList(users)); // 배열을 리스트로

        return players;
    }

    private void printGameResult(Player dealer, List<Player> users) {
        checkOneMoreCard(dealer, users);
        printWinOrLoseResult(dealer, users);
    }

    private void printWinOrLoseResult(Player dealer, List<Player> users) {
        int dealerWinCount = Validator.compareDealerAndUser(dealer, users);
        int dealerLoseCount = users.size() - dealerWinCount;
        OutputView.printGameResult();
        System.out.println(dealer.name + " : " + dealerWinCount + "승 " + dealerLoseCount + "패");

    }

    private void checkOneMoreCard(Player dealer, List<Player> users) {
        List<Player> newUser = checkOneMoreCardPlayers(users); // 사용자 한장 더 받을지
        Player newDealer = checkOneMoreCardDealer(dealer); // 딜러 한장 더 받는지
        OutputView.printPlayerCardTotalResult(newDealer);
        for (Player user : newUser)
            OutputView.printPlayerCardTotalResult(user);
    }

    private List<Player> checkOneMoreCardPlayers(List<Player> users) {
        List<Player> newUser = new ArrayList<>();

        for (Player user : users) {
            boolean check = true;
            String choice;

            while (check) {
                choice = InputView.inputYesOrNoOneCard(user.name);

                if (choice.equals("n"))
                    check = false;
                else {
                    user.cards.add(RandomCard.getRandomCard());
                }

                OutputView.printPlayerOwnCard(user);
            }

            newUser.add(user);
        }
        System.out.println("");

        return newUser;
    }

    private Player checkOneMoreCardDealer(Player player) {
        if (player.getCardTotalSum() < DEALER_ONE_MORE_CARD_STANDARD_NUMBER) {
            player.cards.add(RandomCard.getRandomCard());
            OutputView.printDealerOneCardMessage();
            System.out.println("");
        }

        return player;
    }

}
