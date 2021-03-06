package controller;

import domain.*;
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
        String names;

        do {
            names = InputView.getParticipantNames();
            checkInputNames(names);
        } while (!names.contains(","));

        return BlackJackGame.getParticipantsByNames(names);
    }

    private void checkInputNames(String names) {
        if (!names.contains(",")) {
            OutputView.printInputNamesErrorMessage();
        }
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
        boolean isAdded;
        do {
            isAdded = getWhetherAddOrNot(participant.getName());
            addAdditionalCard(isAdded, participant);
        } while (isAdded);

        printCurrentCard(participant);
    }

    private boolean getWhetherAddOrNot(String name) {
        String whetherAddOrNot = InputView.canGetAdditionCard(name);

        if (whetherAddOrNot.equals("y")) {
            return true;
        }

        if (whetherAddOrNot.equals("n")) {
            return false;
        }

        OutputView.printInputAdditionalCardErrorMessage();

        return getWhetherAddOrNot(name);
    }

    private void addAdditionalCard(boolean isAdded, Participant participant) {
        if (isAdded) {
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
            OutputView.printLine();
            OutputView.printAdditionalCard();
            dealer.receiveCard();
        }
    }

    public void printFinalCardState(Participants participants, Dealer dealer) {
        CardState cardState = BlackJackGame.getCardStates(dealer.getCards());
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
