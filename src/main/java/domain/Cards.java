package domain;

import java.util.List;

public class Cards {
    List<Card> cards;

    public Cards (List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
