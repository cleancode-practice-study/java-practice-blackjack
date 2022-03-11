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
        List<String> names = getUserNames();
        List<Player> users = Player.createUsers(names);

        Player dealer = Player.createDealer();

        OutputView.printPlayerInitialMessage(names);
        System.out.println("");

        printPlayerInitialCards(dealer, users); // 초기 부여 받은 카드 출력
        System.out.println("");

        List<Player> newUserCards = checkOneMoreCardUsers(users);
        Player newDealerCards = checkOneMoreCardDealer(dealer);

        printPlayerNewCards(newDealerCards, newUserCards);
        printGameResult(newDealerCards, newUserCards);
    }

    private List<String> getUserNames() {
        String name = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] names = Player.splitPlayerNames(name); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        List<String> users = new ArrayList<>(Arrays.asList(names)); // 배열을 리스트로

        return users;
    }

    // 플레이어 초기 카드 출력
    private void printPlayerInitialCards(Player dealer, List<Player> users) {
        OutputView.printPlayerOwnCard(dealer);
        System.out.println("");

        for (Player user : users) {
            OutputView.printPlayerOwnCard(user);
            System.out.println("");
        }
    }

    private List<Player> checkOneMoreCardUsers(List<Player> users) {
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


    private void printPlayerNewCards(Player newDealer, List<Player> newUser) {
        OutputView.printPlayerCardTotalResult(newDealer);
        for (Player user : newUser)
            OutputView.printPlayerCardTotalResult(user);
    }

    private void printGameResult(Player dealer, List<Player> users) {
        int dealerWinCount = Validator.compareDealerAndUser(dealer, users);
        int dealerLoseCount = users.size() - dealerWinCount;
        OutputView.printGameResult();
        System.out.println(dealer.name + " : " + dealerWinCount + "승 " + dealerLoseCount + "패");

    }

}
