package controller;

import domain.Card;
import domain.Player;
import domain.Result;

import java.util.ArrayList;
import java.util.List;

public class MainController {
    public static final int DEALER_ONE_MORE_CARD_STANDARD_NUMBER = 16;
    public static final String DEALER = "딜러";

    public void play() {
        List<String> userNames = InputController.getUserNames(); // 게임 참여 이름 입력
        List<Player> users = Player.createUserPlayers(userNames);
        Player dealer = Player.createPlayer(DEALER);

        PrintController.printPlayerInitialCards(dealer, users); // 플레이어들의 초기 부여 받은 카드 출력
        PrintController.printGameResult(getFinalUsers(users), getFinalDealer(dealer)); // 최종 승패 출력
    }

    // 최종 유저 카드
    private List<Player> getFinalUsers(List<Player> users) {
        List<Player> finalUserCards = new ArrayList<>();

        for (Player user : users) {
            Player finalUserCard = checkUserOneMoreCard(user);
            PrintController.printPlayerOwnCard(finalUserCard);
            finalUserCards.add(finalUserCard);
        }

        System.out.println("");

        return finalUserCards;
    }

    // 최종 딜러 카드
    private Player getFinalDealer(Player dealer) {
        List<String> finalDealerCards = dealer.getCards();

        if (Result.getSumNumber(finalDealerCards) <= DEALER_ONE_MORE_CARD_STANDARD_NUMBER) {
            String randomCard = Card.getRandomOneCard();
            finalDealerCards.add(randomCard);
            PrintController.printDealerOneMoreCardMessage();
        }

        return dealer;
    }

    private Player checkUserOneMoreCard(Player user) {
        List<String> userCards = user.getCards();

        while (!InputController.isNoUserAnswer(user)) {
            String randomCard = Card.getRandomOneCard();
            userCards.add(randomCard);
            PrintController.printPlayerOwnCard(user);
        }

        return user;
    }
}