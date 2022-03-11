package controller;

import domain.Player;
import domain.RandomCard;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static final int DEALER_ONE_MORE_CARD_STANDARD_NUMBER = 16;
    public static final String DEALER = "딜러";

    public void play() {
        List<String> names = InputController.getUserNames(); // 게임 참여 이름 입력
        List<Player> users = Player.createUserPlayers(names);
        Player dealer = Player.createPlayer(DEALER); // 카드가 부여된 DEALER 플레이어 생성

        PrintController.printPlayerInitialMessage(names); // 딜러와 halim, jinhee에게 2장의 카드를 나누었습니다.
        PrintController.printPlayerInitialCards(dealer, users); // 플레이어들의 초기 부여 받은 카드 출력

        PrintController.printGameResult(registerNewDealerCards(dealer), registerNewUserCards(users)); // 최종 승패 출력
    }

    private List<Player> registerNewUserCards(List<Player> users) {
        List<Player> newUsersCards = new ArrayList<>();
        for (Player user : users) {
            checkOneMoreCardUser(newUsersCards, user);
            PrintController.printPlayerOwnCard(user);
        }

        return newUsersCards;
    }

    private Player registerNewDealerCards(Player dealer) {
        return checkOneMoreCardDealer(dealer);
    }

    private Player checkOneMoreCardDealer(Player dealer) {
        if (dealer.getCardTotalSum() <= DEALER_ONE_MORE_CARD_STANDARD_NUMBER) {
            dealer.cards.add(RandomCard.getRandomCard());
        }

        return dealer;
    }

    private void checkOneMoreCardUser(List<Player> newUser, Player user) {
        while (!InputController.isNoOneMoreCard(user)) {
            user.cards.add(RandomCard.getRandomCard());
            PrintController.printPlayerOwnCard(user);
        }
        newUser.add(user); // 한장 더 받을지 선택, 카드가 추가된 USER 플레이어
    }
}
