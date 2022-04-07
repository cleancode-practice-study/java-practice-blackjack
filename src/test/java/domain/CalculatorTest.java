package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void A_없는_카드_합_계산() {
        Cards cards = new Cards(Arrays.asList
                (new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.DIAMOND), new Card(CardNumber.SEVEN, CardType.DIAMOND)));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(20);
    }

    @Test
    public void A_11로_계산하는_경우() {
        Cards cards = new Cards(Arrays.asList(new Card(CardNumber.ACE, CardType.HEART), new Card(CardNumber.JACK, CardType.DIAMOND)));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(21);
    }

    @Test
    public void A_1로_계산하는_경우() {
        Cards cards = new Cards(Arrays.asList
                (new Card(CardNumber.ACE, CardType.HEART), new Card(CardNumber.JACK, CardType.DIAMOND), new Card(CardNumber.JACK, CardType.CLOVER)));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(21);
    }

}
