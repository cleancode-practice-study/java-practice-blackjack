package domain;

import demain.Card;
import demain.Cards;
import demain.Participant;
import demain.Participants;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantsTest {
    @Test
    public void 참가자_생성() {
        Participant participantOne = new Participant("진희", new Cards(Arrays.asList(new Card("6하트"), new Card("J클로버"))));
        Participant participantTwo = new Participant("포뇨", new Cards(Arrays.asList(new Card("2하트"), new Card("K다이아몬드"))));

        List<Participant> participant = Arrays.asList(participantOne, participantTwo);

        Participants participants = new Participants(participant);

        assertThat(participants.getParticipants().size()).isEqualTo(2);
        assertThat(participants.getParticipants().get(0).getName()).isEqualTo("진희");
        assertThat(participants.getParticipants().get(1).getName()).isEqualTo("포뇨");
    }

    @Test
    public void 참가자_이름_반환() {
        Participant participantOne = new Participant("진희", new Cards(Arrays.asList(new Card("6하트"), new Card("J클로버"))));
        Participant participantTwo = new Participant("포뇨", new Cards(Arrays.asList(new Card("2하트"), new Card("K다이아몬드"))));

        List<Participant> participant = Arrays.asList(participantOne, participantTwo);

        Participants participants = new Participants(participant);

        List<String> participantNames = participants.getParticipantNames();

        assertThat(participantNames).contains("진희", "포뇨");
    }
}
