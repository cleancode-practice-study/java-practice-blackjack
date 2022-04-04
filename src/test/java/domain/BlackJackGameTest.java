package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BlackJackGameTest {
    @Test
    public void 딜러_생성() {
        Dealer dealer = BlackJackGame.getDealer();

        assertThat(dealer.getName()).isEqualTo("딜러");
        assertThat(dealer.getCards().getCards().size()).isEqualTo(2);
    }

    @Test
    public void 참가자_생성() {
        Participants participants = BlackJackGame.getParticipantsByNames("도원,하림,진희");

        assertThat(participants.getParticipants().get(0).getName()).isEqualTo("도원");
        assertThat(participants.getParticipants().get(1).getName()).isEqualTo("하림");
        assertThat(participants.getParticipants().get(2).getName()).isEqualTo("진희");

        assertThat(participants.getParticipants().get(0).getCards().getCards().size()).isEqualTo(2);
        assertThat(participants.getParticipants().get(1).getCards().getCards().size()).isEqualTo(2);
        assertThat(participants.getParticipants().get(2).getCards().getCards().size()).isEqualTo(2);
    }

    @Test
    public void 카드_현재_상태_확인() {
        Cards cards = new Cards(Arrays.asList(new Card("6하트"), new Card("A스페이드"), new Card("10다이아몬드")));

        CardState cardState = BlackJackGame.getCardStates(cards);

        assertThat(cardState.getCardState()).isNotNull().contains("6하트", "A스페이드", "10다이아몬드");
    }

    @Test
    public void 참가자_게임_결과_확인() {
        Cards dealerCards = new Cards(Arrays.asList(new Card("3클로버"), new Card("11스페이드"), new Card("4하트")));
        Dealer dealer = new Dealer(dealerCards);

        Cards cardsOne = new Cards(Arrays.asList(new Card("1하트"), new Card("A스페이드"), new Card("9다이아몬드")));
        Participant participantOne = new Participant("진희", cardsOne);

        Cards cardsTwo = new Cards(Arrays.asList(new Card("2스페이드"), new Card("J스페이드"), new Card("8다이아몬드")));
        Participant participantTwo = new Participant("포뇨", cardsTwo);

        List<Participant> participant = Arrays.asList(participantOne, participantTwo);
        Participants participants = new Participants(participant);

        ParticipantGameResult participantGameResult = BlackJackGame.getParticipantGameResult(participants, dealer);

        assertThat(participantGameResult.getParticipantResult(participantOne)).isEqualTo("승");
        assertThat(participantGameResult.getParticipantResult(participantTwo)).isEqualTo("승");
    }

    @Test
    public void 딜러_게임_결과_확인() {
        Cards dealerCards = new Cards(Arrays.asList(new Card("3클로버"), new Card("11스페이드"), new Card("4하트")));
        Dealer dealer = new Dealer(dealerCards);

        Cards cardsOne = new Cards(Arrays.asList(new Card("1하트"), new Card("A스페이드"), new Card("9다이아몬드")));
        Participant participantOne = new Participant("진희", cardsOne);

        Cards cardsTwo = new Cards(Arrays.asList(new Card("2스페이드"), new Card("J스페이드"), new Card("8다이아몬드")));
        Participant participantTwo = new Participant("포뇨", cardsTwo);

        List<Participant> participant = Arrays.asList(participantOne, participantTwo);
        Participants participants = new Participants(participant);

        ParticipantGameResult participantGameResult = BlackJackGame.getParticipantGameResult(participants, dealer);

        DealerGameResult dealerGameResult = BlackJackGame.getDealerGameResult(participantGameResult, dealer);

        assertThat(dealerGameResult.getResultForPrint().get(0)).isEqualTo("2패");
    }
}
