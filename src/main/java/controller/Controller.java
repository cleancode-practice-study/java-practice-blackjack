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
        List<String> participantsNames = getParticipantsNames();
        List<Player> players = Creator.createParticipants(participantsNames);
        Participants participants = new Participants(players);

        Player dealer = new Player(DEALER, Creator.getInitialCards());

        printPlayersInitialCards(dealer, participants); // 플레이어들의 초기 부여 받은 카드 출력
        printGameResult(getFinalParticipants(participants), getFinalDealer(dealer)); // 최종 승패 출력
    }

    private List<String> getParticipantsNames() {
        String names = InputView.inputPlayerNames(); // view 호출, 게임의 참여할 사람 이름 입력 받기
        String[] userNames = Convert.splitNames(names); // model 호출, 쉼표 기준으로 잘라서 배열에 저장
        System.out.println("");

        return new ArrayList<>(Arrays.asList(userNames));
    }

    private void printPlayersInitialCards(Player dealer, Participants participants) {
        printParticipantsInitialMessage(participants);
        System.out.println("");

        printPlayerOwnCard(dealer);
        for (Player user : participants.getParticipants())
            printPlayerOwnCard(user);

        System.out.println("");
    }

    // 최종 참여자 카드
    private Participants getFinalParticipants(Participants participants) {
        List<Player> players = new ArrayList<>();

        for (Player player : participants.getParticipants()) {
            Player finalUserCard = checkOneMoreCard(player);
            printPlayerOwnCard(finalUserCard);
            players.add(finalUserCard);
        }

        System.out.println("");

        return new Participants(players);
    }

    // 최종 딜러 카드
    private Player getFinalDealer(Player dealer) {
        Cards cards = dealer.getCards();

        if (Creator.getNumbersSum(cards) <= DEALER_ONE_MORE_CARD_STANDARD_NUMBER) {
            Card randomCard = Card.getRandomCard();
            cards.addCard(randomCard);
            printDealerOneMoreCardMessage();
        }

        return dealer;
    }

    private Player checkOneMoreCard(Player participant) {
        Cards cards = participant.getCards();

        while (!isNoAnswer(participant)) {
            Card randomCard = Card.getRandomCard();
            cards.addCard(randomCard);
            printPlayerOwnCard(participant);
        }

        return participant;
    }

    private boolean isNoAnswer(Player participant) {
        String userName = participant.getName();
        String answer = InputView.inputYesOrNoOneCard(userName);

        return answer.equals(NO);
    }

    private void printDealerOneMoreCardMessage() {
        OutputView.printDealerOneMoreCardMessage();
        System.out.println("");
    }

    private void printPlayerOwnCard(Player participant) {
        OutputView.printPlayerOwnCard(participant);
        System.out.println("");
    }

    private void printParticipantsInitialMessage(Participants participants) {
        String names = Convert.getNamesWithComma(participants.getParticipants());

        OutputView.printPlayersInitialMessage(names);
        System.out.println("");
    }

    private void printPlayersResult(Player dealer, Participants participants) {
        printPlayerResult(dealer);

        for (Player participant : participants.getParticipants())
            printPlayerResult(participant);

        System.out.println("");
    }

    private void printPlayerResult(Player player) {
        Cards cards = player.getCards();

        int playersResult = Creator.getNumbersSum(cards);
        OutputView.printPlayersResultNumber(player, playersResult);
    }

    private void printWinOrLoseResult(Map<String, String> participantsResult) {
        Map<String, Integer> dealerResult = Creator.getDealerResult(participantsResult);

        OutputView.printDealerResult(dealerResult); // 딜러 승패 결과
        OutputView.printParticipantsResult(participantsResult); // 참여자 승패 결과
    }

    private void printGameResult(Participants participants, Player dealer) {
        printPlayersResult(dealer, participants); // 플레이어들의 최종 카드와 결과 출력
        Map<String, String> participantsResult = Creator.getParticipantsResult(dealer, participants); // 유저 승패 결과 구하기

        printWinOrLoseResult(participantsResult); // 최종 승패 결과 출력 (딜러+유저)
    }
}