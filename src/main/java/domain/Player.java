package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<String> card;

    public Player(String playerName, List<String> cards) {
        this.name = playerName;
        this.card = cards;
    }

    public static String[] splitPlayerNames(String names) {

        return names.split(",");
    }

    public String getName() {
        return this.name;
    }

    public List<String> getCards() {
        return this.card;
    }

    public static List<String> getCard() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            cards.add(Card.getRandomCard());
        }

        return cards;
    }

    public int getCardTotalSumResult() {
        int sum = 0;
        return sum;
    }
}
