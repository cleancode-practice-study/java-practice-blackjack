package controller;

import model.BlackJackGame;
import model.Card;
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

        String participantNames = BlackJackGame.getParticipantNames(participants);

        OutputView.printInitCardSetting(participantNames, dealer.getName());
    }

}
