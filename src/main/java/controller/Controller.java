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
        // createParticipant
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        // get cards
        getInitCards(participants, dealer);
        getAdditionalCards(participants);
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
        OutputView.printReceiveCardState(dealer.getCards());
        for (Participant participant : participants) {
            OutputView.printReceiveCardState(participant.getCards());
        }
    }

    public void getAdditionalCards(List<Participant> participants) {
        OutputView.printLine();
        for (Participant participant : participants) {
            getAdditionalCardsLoop(participant);
        }
    }

    private void getAdditionalCardsLoop(Participant participant) {
        boolean isAdded;
        do {
            isAdded = InputView.getAdditionCard(participant.getName());
            if (isAdded) {
                participant.receiveCards(ADDITIONAL_CARD_COUNT);
                String cards = participant.getCards();
                OutputView.printReceiveCardState(cards);
            }
        } while (isAdded);

        String cards = participant.getCards();
        OutputView.printReceiveCardState(cards);
    }


}
