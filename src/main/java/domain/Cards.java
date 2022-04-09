package domain;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private static final int MIN_ACE_NUMBER = 1;
    private static final int MAX_ACE_NUMBER = 11;
    private static final int TEN = 10;
    private static final int INITIAL_CARD_COUNT = 2;

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public static Cards getInitialCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(Card.getRandomCard());

        return new Cards(cards);
    }

    public static int getSum(Cards cards) {
        int sum = 0;

        for (Card card : cards.getCards()) {
            char number = card.getCard().charAt(0);

            if (Card.isMinAceNumber(sum) && Card.isAceCard(number)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (!Card.isMinAceNumber(sum) && Card.isAceCard(number)) {
                sum += MAX_ACE_NUMBER;
                continue;
            }

            if (Card.isSpecialCard(number)) {
                sum += TEN;
                continue;
            }

            sum += Character.getNumericValue(number);
        }

        return sum;
    }
}
