package model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCardCreatorTest {
    @Test
    public void 랜덤_카드_생성() {
        Card card = RandomCardCreator.getRandomCard();

        assertThat(card).isNotNull();
    }
}
