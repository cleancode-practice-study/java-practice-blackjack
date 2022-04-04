package domain;

import java.util.*;

public class RandomCardCreator {
    private static final int CARD_NUMBER_PER_TYPE = 14;
    private static final int CARD_TYPE_COUNT = 3;

    private static final Random random = new Random();

    private static final Set<String> cards = new HashSet<>();

    public static Card getRandomCard() {
        int randomCardNumber = getRandomNumber(CARD_NUMBER_PER_TYPE);
        int randomCardType = getRandomNumber(CARD_TYPE_COUNT);

        String cardName = CardNumber.valueOf(randomCardNumber).getCardNumber() + CardType.valueOf(randomCardType).getCardType();

        if (!cards.contains(cardName)) {
            cards.add(cardName);
            return new Card(cardName);
        }

        return getRandomCard();
    }

    private static int getRandomNumber(int end) {
        return random.nextInt(end);
    }
}
