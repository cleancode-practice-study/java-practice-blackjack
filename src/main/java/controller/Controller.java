package controller;

import model.BlackJackGame;
import model.Dealer;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private static final int ADDITIONAL_CARD_COUNT = 1;

    public void run() {
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        getInitCards(participants, dealer);
        getParticipantAdditionalCards(participants);

        getDealerCard(dealer);

        getFinalCardState(participants, dealer);
        BlackJackGame.setResult(participants, dealer);
        printFinalGameResult(participants, dealer);
    }

    public List<Participant> createParticipants() {
        String names = InputView.getParticipantNames();
        return BlackJackGame.getParticipants(names);
    }

    public void getInitCards(List<Participant> participants, Dealer dealer) {
        BlackJackGame.initCards(participants, dealer);

        String participantNames = BlackJackGame.getParticipantNames(participants);

        OutputView.printInitCardSetting(participantNames, dealer.getName());
        OutputView.printReceiveCardState(dealer.getCardNames());
        for (Participant participant : participants) {
            OutputView.printReceiveCardState(participant.getCardNames());
        }
    }

    public void getParticipantAdditionalCards(List<Participant> participants) {
        OutputView.printLine();
        for (Participant participant : participants) {
            getAdditionalCardsLoop(participant);
        }
    }

    private void getAdditionalCardsLoop(Participant participant) {
        boolean isAdded;
        do {
            isAdded = InputView.getAdditionCard(participant.getName());
            addAdditionalCard(isAdded, participant);
        } while (isAdded);

        printCurrentCard(participant);
    }

    private void addAdditionalCard(boolean isAdded, Participant participant) {
        if (isAdded) {
            participant.receiveCards(ADDITIONAL_CARD_COUNT);
            printCurrentCard(participant);
        }
    }

    private void printCurrentCard(Participant participant) {
        String cards = participant.getCardNames();
        OutputView.printReceiveCardState(cards);
    }

    private void getDealerCard(Dealer dealer) {
        if (dealer.isEnough()) {
            getDealerAdditionalCards(dealer);
        }
    }

    public void getDealerAdditionalCards(Dealer dealer) {
        OutputView.printLine();
        OutputView.printAdditionalCard();
        dealer.receiveCards(ADDITIONAL_CARD_COUNT);
    }

    public void getFinalCardState(List<Participant> participants, Dealer dealer) {
        String dealerState = dealer.getCardSumResult();
        OutputView.printCardFinalState(dealerState);

        for (Participant participant : participants) {
            String participantState = participant.getCardSumResult();
            OutputView.printCardFinalState(participantState);
        }
    }

    public void printFinalGameResult(List<Participant> participants, Dealer dealer) {
        OutputView.printFinalResult();
        OutputView.printFinalGameResult(dealer.getGameResult());

        for (Participant participant : participants) {
            OutputView.printFinalGameResult(participant.getGameResult());
        }
    }

}
