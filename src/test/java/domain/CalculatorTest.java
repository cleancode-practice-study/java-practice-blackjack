package domain;

import demain.Calculator;
import demain.Card;
import demain.Cards;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    public void A_없는_카드_합_계산() {
        Cards cards = new Cards(Arrays.asList(new Card("3하트"), new Card("J다이아몬드"), new Card("7스페이드")));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(20);
    }

    @Test
    public void A_11로_계산하는_경우() {
        Cards cards = new Cards(Arrays.asList(new Card("A하트"), new Card("J다이아몬드")));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(21);
    }

    @Test
    public void A_1로_계산하는_경우() {
        Cards cards = new Cards(Arrays.asList(new Card("A하트"), new Card("J다이아몬드"), new Card("K클로버")));

        int cardSum = Calculator.getCardSum(cards);

        assertThat(cardSum).isEqualTo(21);
    }

}
