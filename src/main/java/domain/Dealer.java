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

    public String getGameResult(String result) {
        if (result.equals(GameResultType.WIN.getCardType())) {
            return GameResultType.LOSE.getCardType();
        }

        if (result.equals(GameResultType.LOSE.getCardType())) {
            return GameResultType.WIN.getCardType();
        }

        return GameResultType.DRAW.getCardType();
    }
}
