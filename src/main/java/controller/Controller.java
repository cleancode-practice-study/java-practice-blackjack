package controller;

import model.BlackJackGame;
import model.Calculator;
import model.Dealer;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller {
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
        OutputView.printInitCardSetting(participants, dealer.getName());

        List<String> cardState = BlackJackGame.getCardStates(dealer.getCards());

        OutputView.printReceiveCardState(dealer.getName(), cardState);

        for (Participant participant : participants) {
            cardState = BlackJackGame.getCardStates(participant.getCards());
            OutputView.printReceiveCardState(participant.getName(), cardState);
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
        List<String> cardState = BlackJackGame.getCardStates(participant.getCards());
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

    public void printFinalCardState(List<Participant> participants, Dealer dealer) {
        List<String> cardState;
        cardState = BlackJackGame.getCardStates(dealer.getCards());
        OutputView.printCardFinalState(dealer.getName(), cardState, Calculator.getCardSum(dealer.getCards()));

        for (Participant participant : participants) {
            cardState = BlackJackGame.getCardStates(participant.getCards());
            OutputView.printCardFinalState(participant.getName(), cardState, Calculator.getCardSum(participant.getCards()));
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
