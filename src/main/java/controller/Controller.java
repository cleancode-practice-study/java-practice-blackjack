package controller;

import model.BlackJackGame;
import model.Dealer;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
    private static final int ADDITIONAL_CARD_COUNT = 1;

    public void run() {
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        initCards(participants, dealer);
        
        receiveParticipantsAdditionalCards(participants);
        receiveDealerCard(dealer);

        printFinalCardState(participants, dealer);
        printFinalGameResult(participants, dealer);
    }

    public List<Participant> createParticipants() {
        String names = InputView.getParticipantNames();
        return BlackJackGame.getParticipantsByNames(names);
    }

    public void initCards(List<Participant> participants, Dealer dealer) {
        BlackJackGame.initCards(participants, dealer);

        OutputView.printInitCardSetting(participants, dealer.getName());

        OutputView.printReceiveCardState(dealer.getName(), dealer.getCards());
        for (Participant participant : participants) {
            OutputView.printReceiveCardState(participant.getName(), participant.getCards());
        }
    }

    public void receiveParticipantsAdditionalCards(List<Participant> participants) {
        OutputView.printLine();
        for (Participant participant : participants) {
            receiveEachParticipantAdditionalCards(participant);
        }
    }

    private void receiveEachParticipantAdditionalCards(Participant participant) {
        boolean canAdded;
        do {
            canAdded = InputView.getAdditionCard(participant.getName());
            addAdditionalCard(canAdded, participant);
        } while (canAdded);

        printCurrentCard(participant);
    }

    private void addAdditionalCard(boolean canAdded, Participant participant) {
        if (canAdded) {
            participant.receiveCards(ADDITIONAL_CARD_COUNT);
            printCurrentCard(participant);
        }
    }

    private void printCurrentCard(Participant participant) {
        OutputView.printReceiveCardState(participant.getName(), participant.getCards());
    }

    private void receiveDealerCard(Dealer dealer) {
        if (dealer.isEnough()) {
            receiveDealerAdditionalCards(dealer);
        }
    }

    public void receiveDealerAdditionalCards(Dealer dealer) {
        OutputView.printLine();
        OutputView.printAdditionalCard();
        dealer.receiveCards(ADDITIONAL_CARD_COUNT);
    }

    public void printFinalCardState(List<Participant> participants, Dealer dealer) {
        OutputView.printCardFinalState(dealer.getName(), dealer.getCards(), dealer.getCardSum());

        for (Participant participant : participants) {
            OutputView.printCardFinalState(participant.getName(), participant.getCards(), participant.getCardSum());
        }
    }

    public void printFinalGameResult(List<Participant> participants, Dealer dealer) {
        Map<String, String> participantGameResult = BlackJackGame.getParticipantGameResult(participants, dealer);
        List<String> dealerGameResult = BlackJackGame.getDealerGameResult(participantGameResult, dealer);

        OutputView.printFinalResult();
        OutputView.printFinalDealerResult(dealer.getName(), dealerGameResult);

        for (Participant participant : participants) {
            String participantName = participant.getName();
            OutputView.printFinalParticipantResult(participantName, participantGameResult.get(participantName));
        }
    }

}
