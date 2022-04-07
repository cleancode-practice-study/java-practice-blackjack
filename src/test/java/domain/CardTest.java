package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    public void 카드_생성() {
        Card card = new Card(CardNumber.ACE, CardType.CLOVER);

        assertThat(card.getCard()).isNotNull().isEqualTo("A클로버");
    }
}
