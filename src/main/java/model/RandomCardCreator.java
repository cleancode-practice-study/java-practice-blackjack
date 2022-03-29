package model;

import java.util.*;

enum CardNumber {
    ONE(0, "1"),
    TWO(1, "2"),
    THREE(2, "3"),
    FOUR(3, "4"),
    FIVE(4, "5"),
    SIX(5, "6"),
    SEVEN(6, "7"),
    EIGHT(7, "8"),
    NINE(8, "9"),
    TEN(9, "10"),
    KING(10, "K"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    ACE(13, "A");

    private final String cardNumber;
    private final int cardNumberIndex;

    public String getCardNumber() {
        return cardNumber;
    }

    private CardNumber(int cardIndex, String cardNumber) {
        this.cardNumber = cardNumber;
        this.cardNumberIndex = cardIndex;
    }

    public static CardNumber valueOf(int randomNumber) {
        for (CardNumber cardNumber : CardNumber.values()) {
            if (cardNumber.cardNumberIndex == randomNumber) {
                return cardNumber;
            }
        }

        throw new IllegalArgumentException(randomNumber + "는 유효하지 않은 값입니다.");
    }
}

enum CardType {
    SPADE(0, "스페이드"),
    HEART(1, "하트"),
    CLOVER(2, "클로버"),
    DIAMOND(3, "다이아몬드");

    private final String cardType;
    private final int cardTypeIndex;

    public String getCardType() {
        return cardType;
    }

    private CardType(int cardTypeIndex, String cardType) {
        this.cardType = cardType;
        this.cardTypeIndex = cardTypeIndex;
    }

    public static CardType valueOf(int randomNumber) {
        for (CardType cardType : CardType.values()) {
            if (cardType.cardTypeIndex == randomNumber) {
                return cardType;
            }
        }

        throw new IllegalArgumentException(randomNumber + "는 유효하지 않은 값입니다.");
    }
}

public class RandomCardCreator {
    private static final int CARD_NUMBER_PER_TYPE = 12;
    private static final int CARD_TYPE_COUNT = 3;

    private static final Random random = new Random();


    public static String getRandomCard() {
        String card;

        int randomCardNumber = getRandomNumber(CARD_NUMBER_PER_TYPE);
        int randomCardType = getRandomNumber(CARD_TYPE_COUNT);

        card = CardNumber.valueOf(randomCardNumber).getCardNumber() + CardType.valueOf(randomCardType).getCardType();

        return card;
    }

    private static int getRandomNumber(int end) {
        return random.nextInt(end);
    }
}
