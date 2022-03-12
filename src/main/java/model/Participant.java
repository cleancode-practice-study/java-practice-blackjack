package model;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private final String name;
    private List<Card> cards = new ArrayList<>();

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveCards() {
        String cardName = RandomCardCreator.getRandomCard();
        Card card = new Card(cardName);
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards;
    }
}
