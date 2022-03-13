package model;

import java.util.*;

public class RandomCardCreator {
    private static final int CARD_NUMBER_PER_TYPE = 12;
    private static final int CARD_TYPE_COUNT = 3;

    private static final Random random = new Random();

    private static final List<String> cardNumbers = Arrays.asList("1", "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "K", "J", "Q", "A");

    private static final List<String> cardTypes = Arrays.asList("스페이드", "하트", "클로버", "다이아몬드");


    public static String getRandomCard() {
        StringBuilder stringBuilder = new StringBuilder();

        int cardNumber = getRandomNumber(CARD_NUMBER_PER_TYPE);
        stringBuilder.append(cardNumbers.get(cardNumber));

        int cardType = getRandomNumber(CARD_TYPE_COUNT);
        stringBuilder.append(cardTypes.get(cardType));

        return stringBuilder.toString();
    }

    private static int getRandomNumber(int end) {
        return random.nextInt(end);
    }
}
