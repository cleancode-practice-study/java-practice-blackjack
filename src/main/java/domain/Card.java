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

    public static String getRandomOneCard() {
        Random random = new Random();

        int randomShapeIdx = random.nextInt(SHAPES_COUNT);
        int randomNumberIdx = random.nextInt(NUMBERS_COUNT);

        String number = CardNumbers.getNumber(randomNumberIdx);
        String shape = CardShapes.getShape(randomShapeIdx);

        return number + shape;
    }

    static boolean isMinAceNumber(char number, int sum) {
        return isAceCard(number) && sum + MAX_ACE_NUMBER > STANDARD_NUMBER;
    }

    static boolean isMaxAceNumber(char number, int sum) {
        return isAceCard(number) && sum + MAX_ACE_NUMBER <= STANDARD_NUMBER;
    }

    static boolean isJackAndQueenAndKingCard(char number) {
        return isJackCard(number) || isQueenCard(number) || isKingCard(number);
    }

    private static boolean isAceCard(char number) {
        return number == ACE;
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
