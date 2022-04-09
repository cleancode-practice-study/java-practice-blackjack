package domain;

import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static String[] splitNames(String names) {
        return names.split(",");
    }

    public static String getNamesWithComma(List<Player> users) {
        List<String> names = new ArrayList<>();

        for (Player user : users) {
            String userName = user.getName();
            names.add(userName);
        }

        return String.join(", ", names);
    }

    public static String getCardsWithComma(Cards cards) {
        List<String> names = new ArrayList<>();

        for (Card card : cards.getCards())
            names.add(card.getCard());

        return String.join(", ", names);
    }
}
