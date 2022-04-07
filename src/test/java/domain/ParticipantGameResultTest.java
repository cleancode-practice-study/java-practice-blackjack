package domain;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantGameResultTest {
    @Test
    public void 참가자_게임_결과_확인() {
        Map<Participant, GameResultType> gameResult = new HashMap<>();

        Participant participantOne = new Participant("진희", new Cards(Arrays.asList
                (new Card(CardNumber.SIX, CardType.HEART), new Card(CardNumber.JACK, CardType.DIAMOND))));
        Participant participantTwo = new Participant("포뇨", new Cards(Arrays.asList
                (new Card(CardNumber.TEN, CardType.SPADE), new Card(CardNumber.THREE, CardType.CLOVER))));


        gameResult.put(participantOne, GameResultType.WIN);
        gameResult.put(participantTwo, GameResultType.DRAW);

        ParticipantGameResult participantGameResult = new ParticipantGameResult(gameResult);

        assertThat(participantGameResult.getParticipantResult(participantOne)).isEqualTo(GameResultType.WIN);
        assertThat(participantGameResult.getParticipantResult(participantTwo)).isEqualTo(GameResultType.DRAW);
    }
}
