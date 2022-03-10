package domain;

import java.util.List;

public class Player {
    public String name;
    public List<String> card;

    Player(String playerName, List<String> cards) {
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

    public String getCardTotalSumResult() {
    }
}
