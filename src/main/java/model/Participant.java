package model;

public class Participant extends Player{
    private static final int STANDARD_NUMBER = 21;
    private static final String WIN = "승";
    private static final String LOSE = "패";
    private static final String DRAW = "무";

    public Participant(String name) {
        this.name = name;
    }

    public String getGameResult(int dealerCardSum) {
        if (dealerCardSum > getCardSum() || getCardSum() > STANDARD_NUMBER) {
            return LOSE;
        }

        if (dealerCardSum < getCardSum()) {
            return WIN;
        }

        return DRAW;
    }
}