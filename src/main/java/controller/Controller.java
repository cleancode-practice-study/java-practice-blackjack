package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Controller {
    public static final int DEALER_ONE_MORE_CARD_STANDARD_NUMBER = 16;
    public static final String DEALER = "딜러";
    public static final String NO = "n";

    public void play() {
        List<String> names = inputParticipantsNames();
        List<Player> players = Creator.createParticipants(names);

        Participants participants = new Participants(players);
        Player dealer = new Player(DEALER, Cards.getInitialCards());

        printPlayersInitialCards(dealer, participants); // 플레이어들의 초기 부여 받은 카드 출력
        printGameResult(getFinalParticipants(participants), getFinalDealer(dealer)); // 최종 승패 출력
    }

    private List<String> inputParticipantsNames() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] userNames = Convert.splitNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        System.out.println("");

        return new ArrayList<>(Arrays.asList(userNames));
    }

    private void printPlayersInitialCards(Player dealer, Participants participants) {
        printPlayersInitialMessage(participants);
        System.out.println("");

        printPlayerCards(dealer);
        for (Player user : participants.getParticipants())
            printPlayerCards(user);

        System.out.println("");
    }

    // 최종 참여자 카드
    private Participants getFinalParticipants(Participants participants) {
        List<Player> players = new ArrayList<>();

        for (Player player : participants.getParticipants()) {
            Player finalUserCard = checkOneMoreCard(player);
            printPlayerCards(finalUserCard);
            players.add(finalUserCard);
        }

        System.out.println("");

        return new Participants(players);
    }

    // 최종 딜러 카드
    private Player getFinalDealer(Player dealer) {
        Cards cards = dealer.getCards();

        if (Cards.getSum(cards) <= DEALER_ONE_MORE_CARD_STANDARD_NUMBER) {
            Card randomCard = Card.getRandomCard();
            cards.addCard(randomCard);
            printDealerOneMoreCardMessage();
        }

        return dealer;
    }

    private Player checkOneMoreCard(Player participant) {
        Cards cards = participant.getCards();

        while (!isNoAnswer(participant)) {
            Card card = Card.getRandomCard();
            cards.addCard(card);
            printPlayerCards(participant);
        }

        return participant;
    }

    private boolean isNoAnswer(Player participant) {
        String name = participant.getName();
        String answer = InputView.inputYesOrNoOneMoreCard(name);

        return answer.equals(NO);
    }

    private void printDealerOneMoreCardMessage() {
        OutputView.printDealerOneMoreCardMessage();
        System.out.println("");
    }

    private void printPlayerCards(Player participant) {
        OutputView.printPlayerCards(participant);
        System.out.println("");
    }

    private void printPlayersInitialMessage(Participants participants) {
        String names = Convert.getNamesWithComma(participants.getParticipants());

        OutputView.printPlayersInitialMessage(names);
        System.out.println("");
    }

    private void printPlayersCardsResult(Player dealer, Participants participants) {
        printPlayerCardsResult(dealer);

        for (Player participant : participants.getParticipants())
            printPlayerCardsResult(participant);

        System.out.println("");
    }

    private void printPlayerCardsResult(Player player) {
        Cards cards = player.getCards();

        int playersResult = Cards.getSum(cards);
        OutputView.printPlayerCardsSumResult(player, playersResult);
    }

    private void printGameResult(Participants participants, Player dealer) {
        printPlayersCardsResult(dealer, participants);

        Map<String, String> participantsResult = Creator.getParticipantsResult(dealer, participants);
        Map<String, Integer> dealerResult = Creator.getDealerResult(participantsResult);

        OutputView.printDealerGameResult(dealerResult);
        OutputView.printParticipantsGameResult(participantsResult);
    }
}