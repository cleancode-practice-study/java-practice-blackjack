package domain;

import java.util.*;

public class BlackJackGame {
    private static final int INIT_CARD_COUNT = 2;

    public static Dealer getDealer() {
        Cards cards = getInitCards();

        return new Dealer(cards);
    }

    public static Participants getParticipantsByNames(String names) {
        List<String> splitNames = splitNames(names);

        List<Participant> participants = new ArrayList<>();

        for (String name : splitNames) {
            Cards cards = getInitCards();
            Participant participant = new Participant(name, cards);
            participants.add(participant);
        }

        return new Participants(participants);
    }

    private static Cards getInitCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0 ; i < INIT_CARD_COUNT ; i++) {
            cards.add(RandomCardCreator.getRandomCard());
        }

        return new Cards(cards);
    }

    private static List<String> splitNames(String names) {
        String[] participantsNames = names.split(",");
        return new ArrayList<>(Arrays.asList(participantsNames));
    }

    public static CardState getCardStates(Cards cards) {
        List<Card> currentCards = cards.getCards();
        List<String> cardNames = new ArrayList<>();

        for (Card card : currentCards) {
            cardNames.add(card.getCard());
        }

        return new CardState(cardNames);
    }

    public static ParticipantGameResult getParticipantGameResult(Participants participants, Dealer dealer) {
        Map<Participant, GameResultType> participantGameResult = new HashMap<>();

        for (Participant participant : participants.getParticipants()) {
            GameResultType participantResult = participant.getGameResult(Calculator.getCardSum(dealer.getCards()));
            participantGameResult.put(participant, participantResult);
        }

        return new ParticipantGameResult(participantGameResult);
    }

    public static DealerGameResult getDealerGameResult(ParticipantGameResult participantGameResult, Dealer dealer) {
        Map<GameResultType, Integer> dealerGameResult = new HashMap<>();

        for (Participant participant : participantGameResult.getKeySet()) {
            GameResultType participantResult = participantGameResult.getParticipantResult(participant);
            GameResultType dealerResult = dealer.getGameResult(participantResult);
            dealerGameResult.put(dealerResult, dealerGameResult.getOrDefault(dealerResult, 0) + 1);
        }

        return new DealerGameResult(dealerGameResult);
    }
}
