package model;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private static final int INIT_COUNT = 0;
    private final String name;
    private List<Card> cards = new ArrayList<>();

    public Participant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void receiveCards(int iterationCount) {
        int count = INIT_COUNT;

        while (count < iterationCount) {
            String cardName = RandomCardCreator.getRandomCard();
            Card card = new Card(cardName);
            cards.add(card);

            count ++;
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
