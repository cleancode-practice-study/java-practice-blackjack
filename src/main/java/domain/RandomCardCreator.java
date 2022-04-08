package domain;

import java.util.*;

public class RandomCardCreator {
    private static final int CARD_NUMBER_PER_TYPE = 13;
    private static final int CARD_TYPE_COUNT = 4;

    private static final Random random = new Random();

    private static final Set<Card> cards = new HashSet<>();

    public static Card getRandomCard() {
        int randomCardNumber = getRandomNumber(CARD_NUMBER_PER_TYPE);
        int randomCardType = getRandomNumber(CARD_TYPE_COUNT);

        CardNumber cardNumber = CardNumber.valueOf(randomCardNumber);
        CardType cardType = CardType.valueOf(randomCardType);

        Card card = new Card(cardNumber, cardType);

        if (!cards.contains(card)) {
            cards.add(card);
            return card;
        }

        return getRandomCard();
    }

    private static int getRandomNumber(int end) {
        return random.nextInt(end);
    }
}
