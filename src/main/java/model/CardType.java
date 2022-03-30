package model;

public enum CardType {
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
