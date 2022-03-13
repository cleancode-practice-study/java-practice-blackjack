package controller;

import model.BlackJackGame;
import model.Calculator;
import model.Dealer;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    private static final int ADDITIONAL_CARD_COUNT = 1;
    private static final int ADDITIONAL_CARD_NUMBER_STANDARD = 16;
    public void run() {
        // createParticipant
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        // get cards
        getInitCards(participants, dealer);
        getParticipantAdditionalCards(participants);

        // if dealer's cards sum in under 21, dealer get one more card
        getDealerCard(dealer);
        getCardState(dealer, participants);

        // get game result

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
        if (Calculator.getCardSum(dealer.getCards()) <= ADDITIONAL_CARD_NUMBER_STANDARD) {
            getDealerAdditionalCards(dealer);
        }
    }

    public void getDealerAdditionalCards(Dealer dealer) {
        OutputView.printLine();
        OutputView.printAdditionalCard();
        dealer.receiveCards(ADDITIONAL_CARD_COUNT);
    }

    public void getCardState(Dealer dealer, List<Participant> participants) {
        printCurrentCard(dealer);
        for (Participant participant : participants) {
            printCurrentCard(participant);
        }
    }

}
