package model;

public class Card {
    private final String card;

    public Card(String cardType) {
        this.card = cardType;
    }

    public String getCardName() {
        return card;
    }
}
