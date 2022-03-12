package model;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackGame {

    public static Dealer getDealer() {
        return new Dealer();
    }

    public static List<Participant> getParticipants(String names) {
        List<String> splitNames = splitNames(names);

        List<Participant> participants = new ArrayList<>();

        for (String name : splitNames) {
            Participant participant = new Participant(name);
            participants.add(participant);
        }

        return participants;
    }

    private static List<String> splitNames(String names) {
        String[] participantsNames = names.split(",");
        return new ArrayList<>(Arrays.asList(participantsNames));
    }

    public static void getCards(List<Participant> participants, Dealer dealer) {
        for (Participant participant : participants) {
            participant.receiveCards();
        }
        dealer.receiveCards();
    }

}
