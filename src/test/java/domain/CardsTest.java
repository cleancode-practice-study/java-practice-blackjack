package domain;

import demain.Card;
import demain.Cards;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    @Test
    public void 카드_생성() {
        Cards cards = new Cards(Arrays.asList(new Card("3하트"), new Card("J다이아몬드"), new Card("7스페이드")));

        assertThat(cards.getCards().size()).isEqualTo(3);
        assertThat(cards.getCards().get(0).getCard()).isEqualTo("3하트");
        assertThat(cards.getCards().get(1).getCard()).isEqualTo("J다이아몬드");
        assertThat(cards.getCards().get(2).getCard()).isEqualTo("7스페이드");
    }
}
