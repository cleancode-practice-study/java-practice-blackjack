package controller;

import model.BlackJackGame;
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

        // get game result
    }
    public List<Participant> createParticipants() {
        String names = InputView.getParticipantInputMessage();
        List<Participant> participants = BlackJackGame.getParticipants(names);
        return participants;
    }
}
