package domain;

import java.util.Random;

public class Card {
    private static final int MAX_ACE_NUMBER = 11;
    private static final int STANDARD_NUMBER = 21;
    private static final char ACE = 'A';
    private static final char JACK = 'J';
    private static final char QUEEN = 'Q';
    private static final char KING = 'K';

    public static String getRandomOneCard() {
        Random random = new Random();

        String[] shapes = {"클로버", "다이아몬드", "스페이드", "하트"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q"};

        int randomShapeIdx = random.nextInt(shapes.length);
        int randomNumberIdx = random.nextInt(numbers.length);

        return numbers[randomNumberIdx] + shapes[randomShapeIdx];
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
