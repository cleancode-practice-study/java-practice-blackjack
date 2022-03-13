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

        List<String> names = BlackJackGame.getParticipantNames(participants);
        String participantNames = String.join(", ", names);

        OutputView.printInitCardSetting(participantNames, dealer.getName());
        OutputView.printDealerReceiveCardState(dealer.getName(), BlackJackGame.getCardNames(dealer.getCards()));
        printParticipantCard(participants);
    }

    public void printParticipantCard(List<Participant> participants) {
        for (Participant participant : participants) {
            String name = participant.getName();
            String cards = BlackJackGame.getCardNames(participant.getCards());

            OutputView.printParticipantReceiveCardState(name, cards);
        }
    }

    public void getAdditionalCards(List<Participant> participants) {
        for (Participant participant : participants) {
            boolean isAdded;
            do {
                isAdded = InputView.getAdditionCard(participant.getName());
                if (isAdded) {
                    participant.receiveCards(ADDITIONAL_CARD_COUNT);
                }
            } while (isAdded);

        }
    }




}
