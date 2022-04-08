package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Creator {
    private static final int MIN_ACE_NUMBER = 1;
    private static final int MAX_ACE_NUMBER = 11;
    private static final int TEN = 10;
    private static final int INITIAL_CARD_COUNT = 2;

    public static Map<String, Integer> getDealerResult(Map<String, String> participantsResult) {
        Map<String, Integer> dealerResult = new HashMap<String, Integer>() {
            {
                put(ResultTypes.WIN.getResultType(), 0);
                put(ResultTypes.LOSE.getResultType(), 0);
                put(ResultTypes.TIE.getResultType(), 0);
            }
        };

        List<String> result = new ArrayList<>();
        for (String userName : participantsResult.keySet())
            result.add(participantsResult.get(userName));

        for (String str : result)
            dealerResult.put(str, dealerResult.getOrDefault(str, 0) + 1);

        return dealerResult;
    }

    public static Map<String, String> getParticipantsResult(Player dealer, Participants participants) {
        Map<String, String> participantsResult = new HashMap<>();

        for (Player user : participants.getParticipants())
            Validator.checkParticipantResult(participantsResult, dealer, user);

        return participantsResult;
    }

    public static int getNumbersSum(Cards cards) {
        int sum = 0;

        for (Card card : cards.getCards()) {
            char number = card.getCard().charAt(0);

            if (Card.isMinAceNumber(sum) && Card.isAceCard(number)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (!Card.isMinAceNumber(sum) && Card.isAceCard(number)) {
                sum += MAX_ACE_NUMBER;
                continue;
            }

            if (Card.isSpecialCard(number)) {
                sum += TEN;
                continue;
            }

            sum += Character.getNumericValue(number);
        }

        return sum;
    }

    public static Cards getInitialCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(Card.getRandomCard());

        return new Cards(cards);
    }

    public static List<Player> createParticipants(List<String> names) {
        return names.stream().map(name -> new Player(name, getInitialCards())).collect(Collectors.toList());
    }
}
