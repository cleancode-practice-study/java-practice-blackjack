package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTypeTest {
    @Test
    public void 올바른_카드_타입_받기() {
        int cardIndex = 3;

        CardType cardType = CardType.valueOf(cardIndex);

        assertThat(cardType.getCardType()).isEqualTo("다이아몬드");
    }

    @Test
    public void 올바르지_않은_카드_타입_받기() {
        int cardIndex = 4;

        Assertions.assertThrows(IllegalArgumentException.class, () -> CardType.valueOf(cardIndex));
    }
}
