package demain;

public enum CardNumber {
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
