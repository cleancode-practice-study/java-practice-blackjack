package model;

import java.util.List;

public class Calculator {
    private static final int JACK_QUEEN_KING_NUMBER = 10;
    private static final int A_NUMBER_ONE = 1;
    private static final int A_NUMBER_ELEVEN = 11;

    public static int getCardSum(List<String> cards) {
        int sum = 0;
        for (String card : cards) {
            String cardNumber = card.replaceAll("[가-힣]", "");
            sum += convertToNumber(cardNumber);
        }
        return sum;
    }

    private static int convertToNumber(String type) {
        int number;

        if (type.equals("J") || type.equals("K") || type.equals("Q")) {
            number = JACK_QUEEN_KING_NUMBER;
            return number;
        }

        if (type.equals("A")) {
            number = A_NUMBER_ELEVEN;
            return number;
        }

        return Integer.parseInt(type);
    }

}
