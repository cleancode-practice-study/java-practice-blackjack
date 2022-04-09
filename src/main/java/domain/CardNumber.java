package domain;

public enum CardNumber {
    TWO(0, "2"),
    THREE(1, "3"),
    FOUR(2, "4"),
    FIVE(3, "5"),
    SIX(4, "6"),
    SEVEN(5, "7"),
    EIGHT(6, "8"),
    NINE(7, "9"),
    TEN(8, "10"),
    KING(9, "K"),
    JACK(10, "J"),
    QUEEN(11, "Q"),
    ACE(12, "A");

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
