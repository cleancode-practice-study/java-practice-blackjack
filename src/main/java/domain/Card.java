package domain;

public class Card {
    CardNumber cardNumber;
    CardType cardType;

    public Card(CardNumber cardNumber, CardType cardType) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
    }

    public String getCard() {
        return cardNumber.getCardNumber() + cardType.getCardType();
    }

    public String getCardNumber() {
        return cardNumber.getCardNumber();
    }
}
