package controller;

import model.*;
import view.InputView;
import view.OutputView;

public class Controller {
    public void run() {
        Participants participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        printInitCardState(participants, dealer);
        
        receiveParticipantsAdditionalCards(participants);
        receiveDealerCard(dealer);

        printFinalCardState(participants, dealer);
        printFinalGameResult(participants, dealer);
    }

    public Participants createParticipants() {
        String names = InputView.getParticipantNames();
        return BlackJackGame.getParticipantsByNames(names);
    }

    public void printInitCardState(Participants participants, Dealer dealer) {
        OutputView.printInitCardSetting(participants, dealer.getName());

        CardState cardState = BlackJackGame.getCardStates(dealer.getCards());

        OutputView.printReceiveCardState(dealer.getName(), cardState);

        for (Participant participant : participants.getParticipants()) {
            cardState = BlackJackGame.getCardStates(participant.getCards());
            OutputView.printReceiveCardState(participant.getName(), cardState);
        }
    }

    public void receiveParticipantsAdditionalCards(Participants participants) {
        OutputView.printLine();
        for (Participant participant : participants.getParticipants()) {
            receiveEachParticipantAdditionalCards(participant);
        }
    }

    private void receiveEachParticipantAdditionalCards(Participant participant) {
        boolean canAdded;
        do {
            canAdded = InputView.canGetAdditionCard(participant.getName());
            addAdditionalCard(canAdded, participant);
        } while (canAdded);

        printCurrentCard(participant);
    }

    private void addAdditionalCard(boolean canAdded, Participant participant) {
        if (canAdded) {
            participant.receiveCard();
            printCurrentCard(participant);
        }
    }

    private void printCurrentCard(Participant participant) {
        CardState cardState = BlackJackGame.getCardStates(participant.getCards());
        OutputView.printReceiveCardState(participant.getName(), cardState);
    }

    private void receiveDealerCard(Dealer dealer) {
        if (dealer.isEnough()) {
            receiveDealerAdditionalCards(dealer);
        }
    }

    public void receiveDealerAdditionalCards(Dealer dealer) {
        OutputView.printLine();
        OutputView.printAdditionalCard();
        dealer.receiveCard();
    }

    public void printFinalCardState(Participants participants, Dealer dealer) {
        CardState cardState;
        cardState = BlackJackGame.getCardStates(dealer.getCards());
        OutputView.printCardFinalState(dealer.getName(), cardState, Calculator.getCardSum(dealer.getCards()));

        for (Participant participant : participants.getParticipants()) {
            cardState = BlackJackGame.getCardStates(participant.getCards());
            OutputView.printCardFinalState(participant.getName(), cardState, Calculator.getCardSum(participant.getCards()));
        }
    }

    public void printFinalGameResult(Participants participants, Dealer dealer) {
        ParticipantGameResult participantGameResult = BlackJackGame.getParticipantGameResult(participants, dealer);
        DealerGameResult dealerGameResult = BlackJackGame.getDealerGameResult(participantGameResult, dealer);

        OutputView.printFinalResult();
        OutputView.printFinalDealerResult(dealer.getName(), dealerGameResult);

        for (Participant participant : participants.getParticipants()) {
            String participantName = participant.getName();
            OutputView.printFinalParticipantResult(participantName, participantGameResult.getParticipantResult(participant));
        }
    }

}
