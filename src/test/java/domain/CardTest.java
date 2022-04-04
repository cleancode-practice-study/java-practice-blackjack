package domain;

import demain.Card;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {
    @Test
    public void 카드_생성() {
        String name = "5하트";

        Card card = new Card(name);

        assertThat(card.getCard()).isNotNull().isEqualTo("5하트");
    }
}
