package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participant {
    private static final int INIT_COUNT = 0;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";


    private List<String> cards = new ArrayList<>();
    private Map<String, Integer> gameResult = new HashMap<>();
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

    public int getCardSum() {
        return Calculator.getCardSum(cards);
    }

    public String getCardSumResult() {
        return getCardNames() + " - 결과: " + getCardSum();
    }

    public void addGameResult(String result) {
        gameResult.put(result, gameResult.getOrDefault(result, 0) + 1);
    }

    public String getGameResult() {
        String result = name + ": ";

        if (gameResult.containsKey(WIN)) {
            result += gameResult.get(WIN) + WIN + " ";
        }

        if (gameResult.containsKey(LOSE)) {
            result += gameResult.get(LOSE) + LOSE + " ";
        }

        if (gameResult.containsKey(DRAW)) {
            result += gameResult.get(DRAW) + DRAW + " ";
        }

        return result;
    }
}