package domain;

public enum CardNumbers {
    TWO(0, "2"),
    THREE(1, "3"),
    FOUR(2, "4"),
    FIVE(3, "5"),
    SIX(4, "6"),
    SEVEN(5, "7"),
    EIGHT(6, "8"),
    NINE(7, "9"),
    ACE(8, "A"),
    JACK(9, "J"),
    KING(10, "K"),
    QUEEN(11, "Q");

    private static int count = 0;
    private final int idx;
    private final String number;

    CardNumbers(int cardIdx, String cardNumber) {
        this.idx = cardIdx;
        this.number = cardNumber;
    }

    public static String getNumber(int cardIdx) {
        for (CardNumbers cardNumbers : CardNumbers.values()) {
            if (cardIdx == cardNumbers.idx)
                return cardNumbers.number;
        }
        return null;
    }
}
