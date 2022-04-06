package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {
    @Test
    public void 카드_생성() {
        Cards cards = new Cards(Arrays.asList
                (new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.DIAMOND), new Card(CardNumber.SEVEN, CardType.SPADE)));

        assertThat(cards.getCards().size()).isEqualTo(3);
        assertThat(cards.getCards().get(0).getCard()).isEqualTo("3하트");
        assertThat(cards.getCards().get(1).getCard()).isEqualTo("J다이아몬드");
        assertThat(cards.getCards().get(2).getCard()).isEqualTo("7스페이드");
    }
}
