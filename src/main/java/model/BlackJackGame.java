package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlackJackGame {
    private static final int INIT_CARD_COUNT = 2;
    private static final int STANDARD_NUMBER = 21;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "승";

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

    public static void initCards(List<Participant> participants, Dealer dealer) {
        for (Participant participant : participants) {
            participant.receiveCards(INIT_CARD_COUNT);
        }
        dealer.receiveCards(INIT_CARD_COUNT);
    }

    public static String getParticipantNames(List<Participant> participants) {
        List<String> participantNames = new ArrayList<>();

        for (Participant participant : participants) {
            participantNames.add(participant.getName());
        }

        return String.join(", ", participantNames);
    }

    // 딜러 기준으로 승패무 결정
    public static void getResult(List<Participant> participants, Dealer dealer) {
        int differenceBetweenDealer = STANDARD_NUMBER - dealer.getCardSum();

        for (Participant participant : participants) {
            String participantResult = getParticipantResult(participant, differenceBetweenDealer);
            participant.addGameResult(participantResult);

            String dealerResult = getDealerResult(participantResult);
            dealer.addGameResult(dealerResult);
        }
    }

    private static String getParticipantResult(Participant participant, int dealerResult) {
        int participantResult = STANDARD_NUMBER - participant.getCardSum();

        if (participant.getCardSum() > 21) {
            return LOSE;
        }

        if (dealerResult > participantResult) {
            return WIN;
        }

        if (dealerResult < participantResult) {
            return LOSE;
        }

        return DRAW;
    }

    private static String getDealerResult(String result) {
        if (result.equals(WIN)) {
            return LOSE;
        }

        if (result.equals(LOSE)) {
            return WIN;
        }

        return DRAW;
    }

}
