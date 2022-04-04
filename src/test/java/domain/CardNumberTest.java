package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardNumberTest {
    @Test
    public void 올바른_카드_넘버_받기() {
        int cardIndex = 13;

        CardNumber cardNumber = CardNumber.valueOf(cardIndex);

        assertThat(cardNumber.getCardNumber()).isEqualTo("A");
    }

    @Test
    public void 올바르지_않은_카드_넘버_받기() {
        int cardIndex = 14;

        Assertions.assertThrows(IllegalArgumentException.class, () -> CardNumber.valueOf(cardIndex));
    }
}
