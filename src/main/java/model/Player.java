package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private static final int INIT_COUNT = 0;

    private final List<String> cards = new ArrayList<>();
    protected String name;

    public String getName() {
        return name;
    }

    public List<String> getCards() { return cards; }

    public void receiveCards(int iterationCount) {
        int count = INIT_COUNT;

        while (count < iterationCount) {
            String cardName = RandomCardCreator.getRandomCard();
            cards.add(cardName);
            count ++;
        }
    }

    public int getCardSum() {
        return Calculator.getCardSum(cards);
    }

}
