package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    @Test
    public void 딜러_카드_추가() {
        List<Card> cards = new ArrayList<>(Arrays.asList
                (new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));
        Cards dealerCards = new Cards(cards);

        Dealer dealer = new Dealer(dealerCards);

        dealer.receiveCard();

        assertThat(dealer.getCards().getCards().size()).isEqualTo(3);
    }

    @Test
    public void 딜러_카드_합이_16_이상일_경우() {
        Cards dealerCards = new Cards(Arrays.asList
                (new Card(CardNumber.TEN, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));

        Dealer dealer = new Dealer(dealerCards);

        assertThat(dealer.isEnough()).isFalse();
    }

    @Test
    public void 딜러_카드_합이_16_이하일_경우() {
        Cards dealerCards = new Cards(Arrays.asList(new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));

        Dealer dealer = new Dealer(dealerCards);

        assertThat(dealer.isEnough()).isTrue();
    }

    @Test
    public void 딜러_패_했을_경우() {
        Dealer dealer = new Dealer(new Cards(Arrays.asList
                (new Card(CardNumber.SEVEN, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER))));

        GameResultType dealerGameResult = dealer.getGameResult(GameResultType.WIN);

        assertThat(dealerGameResult).isEqualTo(GameResultType.LOSE);
    }

    @Test
    public void 딜러_승_했을_경우() {
        Dealer dealer = new Dealer(new Cards(Arrays.asList
                (new Card(CardNumber.SEVEN, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER))));

        GameResultType dealerGameResult = dealer.getGameResult(GameResultType.LOSE);

        assertThat(dealerGameResult).isEqualTo(GameResultType.WIN);
    }

    @Test
    public void 딜러_무승부일_경우() {
        Dealer dealer = new Dealer(new Cards(Arrays.asList
                (new Card(CardNumber.SEVEN, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER))));

        GameResultType dealerGameResult = dealer.getGameResult(GameResultType.DRAW);

        assertThat(dealerGameResult).isEqualTo(GameResultType.DRAW);
    }

}

