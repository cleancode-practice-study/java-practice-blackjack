package domain;

import java.util.Arrays;

public enum CardNumbers {
    TWO(0, '2'),
    THREE(1, '3'),
    FOUR(2, '4'),
    FIVE(3, '5'),
    SIX(4, '6'),
    SEVEN(5, '7'),
    EIGHT(6, '8'),
    NINE(7, '9'),
    ACE(8, 'A'),
    JACK(9, 'J'),
    KING(10, 'K'),
    QUEEN(11, 'Q');

    private final int idx;
    private final char number;

    CardNumbers(int cardIdx, char cardNumber) {
        this.idx = cardIdx;
        this.number = cardNumber;
    }

    public static CardNumbers getCardNumber(int cardIdx) {
        return Arrays.stream(CardNumbers.values()).filter(num -> num.idx == cardIdx).findAny().orElse(null);
    }

    public char getNumber() {
        return this.number;
    }
}
