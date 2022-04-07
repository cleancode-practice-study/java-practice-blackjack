package domain;

public class Dealer extends Player {
    private static final int ADDITIONAL_CARD_STANDARD = 16;

    public Dealer(Cards cards) {
        this.name = "딜러";
        this.cards = cards;
    }

    public boolean isEnough() {
        return Calculator.getCardSum(cards) <= ADDITIONAL_CARD_STANDARD;
    }

    public GameResultType getGameResult(GameResultType result) {
        if (result.equals(GameResultType.WIN)) {
            return GameResultType.LOSE;
        }

        if (result.equals(GameResultType.LOSE)) {
            return GameResultType.WIN;
        }

        return GameResultType.DRAW;
    }
}
