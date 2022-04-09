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
        List<Player> players = Participants.create(names);

        Participants participants = new Participants(players);
        Player dealer = new Player(DEALER, Cards.getInitialCards());

        printPlayersInitialCards(dealer, participants);
        GameResult gameResult = getGameResult(getFinalParticipants(participants), getFinalDealer(dealer));
        printGameResult(gameResult);
    }

    private List<String> inputParticipantsNames() {
        String names = InputView.inputPlayerNames();
        String[] participantsNames = Convert.splitNames(names);
        System.out.println("");

        return new ArrayList<>(Arrays.asList(participantsNames));
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

    private GameResult getGameResult(Participants participants, Player dealer) {
        printPlayersCardsResult(dealer, participants);

        Map<String, String> participantsResult = GameResultCreator.getParticipantsResult(dealer, participants);
        Map<String, Integer> dealerResult = GameResultCreator.getDealerResult(participantsResult);

        return new GameResult(participantsResult, dealerResult);
    }

    private void printGameResult(GameResult gameResult) {
        OutputView.printDealerGameResult(gameResult.getDealerResult());
        OutputView.printParticipantsGameResult(gameResult.getParticipantsResult());
    }
}