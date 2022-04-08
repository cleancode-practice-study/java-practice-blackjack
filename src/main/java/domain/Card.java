package domain;

import java.util.Random;

public class Card {
    private static final int MAX_ACE_NUMBER = 11;
    private static final int STANDARD_NUMBER = 21;
    private static final int NUMBERS_COUNT = 12;
    private static final int SHAPES_COUNT = 4;
    private static final char ACE = 'A';
    private static final char JACK = 'J';
    private static final char QUEEN = 'Q';
    private static final char KING = 'K';

    private final CardNumbers number;
    private final CardShapes shape;

    public Card(CardNumbers number, CardShapes shape) {
        this.number = number;
        this.shape = shape;
    }

    public static Card getRandomCard() {
        Random random = new Random();

        int randomNumberIdx = random.nextInt(NUMBERS_COUNT);
        int randomShapeIdx = random.nextInt(SHAPES_COUNT);

        CardNumbers number = CardNumbers.valueOf(randomNumberIdx);
        CardShapes shape = CardShapes.valueOf(randomShapeIdx);

        return new Card(number, shape);
    }

    public static boolean isMinAceNumber(int cardsNumberSum) {
        return cardsNumberSum + MAX_ACE_NUMBER > STANDARD_NUMBER;
    }

    public static boolean isSpecialCard(char number) {
        return isJackCard(number) || isQueenCard(number) || isKingCard(number);
    }

    public static boolean isAceCard(char number) {
        return number == ACE;
    }

    public String getCard() {
        return number.getNumber() + shape.getShape();
    }

    private static boolean isJackCard(char number) {
        return number == JACK;
    }

    private static boolean isQueenCard(char number) {
        return number == QUEEN;
    }

    private static boolean isKingCard(char number) {
        return number == KING;
    }
}
