package model;

import java.util.ArrayList;
import java.util.List;

public class Participant {
    private static final int INIT_COUNT = 0;

    private List<String> cards = new ArrayList<>();
    private final String name;

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
            cards.add(cardName);
            count ++;
        }
    }

    public String getCardNames() {
        return name + " 카드: " + String.join(", ", cards);
    }

    public List<String> getCards() {
        return cards;
    }

    public int getCardSum() {
        return Calculator.getCardSum(cards);
    }

    public String getCardSumResult() {
        return getCardNames() + " - 결과: " + getCardSum();
    }
}