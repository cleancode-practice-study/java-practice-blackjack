package controller;

import model.BlackJackGame;
import model.Card;
import model.Dealer;
import model.Participant;
import view.InputView;

import java.util.List;

public class Controller {
    public void run() {
        // createParticipant
        List<Participant> participants = createParticipants();
        Dealer dealer = BlackJackGame.getDealer();

        // get cards
        BlackJackGame.getCards(participants, dealer);

        // get game result
    }
    public List<Participant> createParticipants() {
        String names = InputView.getParticipantInputMessage();
        return BlackJackGame.getParticipants(names);
    }
}
