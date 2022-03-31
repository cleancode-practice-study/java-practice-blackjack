package model;

public class Participant extends Player{
    private static final int STANDARD_NUMBER = 21;

    public Participant(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getGameResult(int dealerCardSum) {
        int cardSum = Calculator.getCardSum(cards);

        if (dealerCardSum > cardSum || cardSum > STANDARD_NUMBER) {
            return GameResultType.LOSE.getCardType();
        }

        if (dealerCardSum < cardSum) {
            return GameResultType.WIN.getCardType();
        }

        return GameResultType.DRAW.getCardType();
    }
}