package model;

public class Dealer extends Player{
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";

    public Dealer(Cards cards) {
        this.name = "딜러";
        this.cards = cards;
    }

    public boolean isEnough() {
        return Calculator.getCardSum(cards) <= 16;
    }

    public String getGameResult(String result) {
        if (result.equals(WIN)) {
            return LOSE;
        }

        if (result.equals(LOSE)) {
            return WIN;
        }

        return DRAW;
    }
}
