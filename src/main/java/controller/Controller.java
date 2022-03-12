package controller;

import model.BlackJackGame;
import model.Dealer;
import model.Participant;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {
    public void run() {
        // createParticipant
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        // get cards
        getCards(participants, dealer);

        // get game result
    }

    public List<Participant> createParticipants() {
        String names = InputView.getParticipantInputMessage();
        return BlackJackGame.getParticipants(names);
    }

    public void getCards(List<Participant> participants, Dealer dealer) {
        BlackJackGame.initCards(participants, dealer);

        List<String> names = BlackJackGame.getParticipantNames(participants);
        String participantNames = String.join(", ", names);

        OutputView.printInitCardSetting(participantNames, dealer.getName());
        OutputView.printDealterReceiveCardState(dealer.getName(), BlackJackGame.getCardNames(dealer.getCards()));
        printParticipantCard(participants);
    }

    public void printParticipantCard(List<Participant> participants) {
        for (Participant participant : participants) {
            String name = participant.getName();
            String cards = BlackJackGame.getCardNames(participant.getCards());

            OutputView.printParticipantReceiveCardState(name, cards);
        }
    }


}
