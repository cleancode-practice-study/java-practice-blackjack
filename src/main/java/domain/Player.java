package domain;

import util.RandomCard;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<String> cards;

    public Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public static String[] splitPlayerNames(String names) {
        return names.split(",");
    }

    public static Player createPlayer(String name, List<String> cards) {
        Player player = new Player(name, cards);

        return player;
    }

    public static List<String> getCard() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            cards.add(RandomCard.getRandomCard());
        }

        return cards;
    }

    public int getCardTotalSum() {
        int sum = 0;

        for (String card : cards) {
            if (card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K') {
                sum += 10;
                break;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }
}

