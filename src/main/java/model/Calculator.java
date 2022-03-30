package model;

import java.util.List;

public class Calculator {
    private static final int CARD_STANDARD = 21;
    private static final int JACK_QUEEN_KING_NUMBER = 10;
    private static final int A_NUMBER_ONE = 1;
    private static final int A_NUMBER_ELEVEN = 11;

    public static int getCardSum(List<String> cards) {
        int sumOne = 0;
        int sumEleven = 0;

        for (String card : cards) {
            String cardNumber = card.replaceAll("[가-힣]", "");
            sumOne += convertToNumberAIsOne(cardNumber);
        }

        for (String card : cards) {
            String cardNumber = card.replaceAll("[가-힣]", "");
            sumEleven += convertToNumberAIsEleven(cardNumber);
        }

        if ((CARD_STANDARD - sumOne < CARD_STANDARD - sumEleven) && (sumOne > 21 && sumEleven > 21) ) {
            return sumOne;
        }

        return sumEleven;
    }

    private static int convertToNumberAIsOne(String type) {
        if (type.equals("J") || type.equals("K") || type.equals("Q")) {
            return JACK_QUEEN_KING_NUMBER;
        }

        if (type.equals("A")) {
            return A_NUMBER_ONE;
        }

        return Integer.parseInt(type);
    }

    private static int convertToNumberAIsEleven(String type) {
        if (type.equals("J") || type.equals("K") || type.equals("Q")) {
            return JACK_QUEEN_KING_NUMBER;
        }

        if (type.equals("A")) {
            return A_NUMBER_ELEVEN;
        }

        return Integer.parseInt(type);
    }

}