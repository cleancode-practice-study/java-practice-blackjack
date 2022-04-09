package domain;

public class Participant extends Player{
    private static final int STANDARD_NUMBER = 21;

    public Participant(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public GameResultType getGameResult(int dealerCardSum) {
        int ParticipantCardSum = Calculator.getCardSum(cards);

        int diffParticipant = Math.abs(ParticipantCardSum - STANDARD_NUMBER);
        int diffDealer = Math.abs(dealerCardSum - STANDARD_NUMBER);

        if (diffParticipant > diffDealer || ParticipantCardSum > STANDARD_NUMBER) {
            return GameResultType.LOSE;
        }

        if (diffDealer > diffParticipant) {
            return GameResultType.WIN;
        }

        return GameResultType.DRAW;
    }
}