package model;

public class Participant extends Player{
    private static final int STANDARD_NUMBER = 21;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";

    public Participant(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getGameResult(int dealerCardSum) {
        int cardSum = Calculator.getCardSum(cards);

        if (dealerCardSum > cardSum || cardSum > STANDARD_NUMBER) {
            return LOSE;
        }

        if (dealerCardSum < cardSum) {
            return WIN;
        }

        return DRAW;
    }
}