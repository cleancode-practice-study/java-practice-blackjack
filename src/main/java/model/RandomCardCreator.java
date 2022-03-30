package model;

import java.util.*;

public class RandomCardCreator {
    private static final int CARD_NUMBER_PER_TYPE = 12;
    private static final int CARD_TYPE_COUNT = 3;

    private static final Random random = new Random();

    public static Card getRandomCard() {
        int randomCardNumber = getRandomNumber(CARD_NUMBER_PER_TYPE);
        int randomCardType = getRandomNumber(CARD_TYPE_COUNT);


        return new Card(CardNumber.valueOf(randomCardNumber).getCardNumber() + CardType.valueOf(randomCardType).getCardType());
    }

    private static int getRandomNumber(int end) {
        return random.nextInt(end);
    }
}
