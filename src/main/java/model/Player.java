package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
    private static final int INIT_COUNT = 0;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";

    private final List<String> cards = new ArrayList<>();
    private final Map<String, Integer> gameResult = new HashMap<>();
    public String name;

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

    public void addGameResult(String result) {
        gameResult.put(result, gameResult.getOrDefault(result, 0) + 1);
    }

    public String getGameResult() {
        String result = name + ": ";

        if (gameResult.containsKey(WIN)) {
            result += getEachGameResult(WIN);
        }

        if (gameResult.containsKey(LOSE)) {
            result += getEachGameResult(LOSE);
        }

        if (gameResult.containsKey(DRAW)) {
            result += getEachGameResult(DRAW);
        }

        return result;
    }

    private String getEachGameResult(String type) {
        if (gameResult.size() > 1 || gameResult.get(type) > 1) {
            return gameResult.get(type) + type + " ";
        }
        return type;
    }
}
