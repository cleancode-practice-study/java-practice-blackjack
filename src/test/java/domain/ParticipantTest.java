package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {
    @Test
    public void 참가자_카드_추가() {
        List<Card> cards = new ArrayList<>(Arrays.asList
                (new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));
        Cards participantCards = new Cards(cards);

        Participant participant = new Participant("진희", participantCards);

        participant.receiveCard();

        assertThat(participant.getCards().getCards().size()).isEqualTo(3);
    }

    @Test
    public void 참가자_승_했을_경우() {
        List<Card> cards = new ArrayList<>(Arrays.asList
                (new Card(CardNumber.ACE, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));
        Cards participantCards = new Cards(cards);

        Participant participant = new Participant("진희", participantCards);

        int dealerCardSum = 18;

        GameResultType gameResult = participant.getGameResult(dealerCardSum);

        assertThat(gameResult).isEqualTo(GameResultType.WIN);
    }

    @Test
    public void 참가자_패_했을_경우() {
        List<Card> cards = new ArrayList<>(Arrays.asList
                (new Card(CardNumber.THREE, CardType.HEART), new Card(CardNumber.JACK, CardType.CLOVER)));
        Cards participantCards = new Cards(cards);

        Participant participant = new Participant("진희", participantCards);

        int dealerCardSum = 18;

        GameResultType gameResult = participant.getGameResult(dealerCardSum);

        assertThat(gameResult).isEqualTo(GameResultType.LOSE);
    }

    @Test
    public void 참가자_무승부일_경우() {
        List<Card> cards = new ArrayList<>(Arrays.asList
                (new Card(CardNumber.EIGHT, CardType.CLOVER), new Card(CardNumber.JACK, CardType.CLOVER)));
        Cards participantCards = new Cards(cards);

        Participant participant = new Participant("진희", participantCards);

        int dealerCardSum = 18;

        GameResultType gameResult = participant.getGameResult(dealerCardSum);

        assertThat(gameResult).isEqualTo(GameResultType.DRAW);
    }
}
