package domain;

import demain.*;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantGameResultTest {
    @Test
    public void 참가자_게임_결과_확인() {
        Map<Participant, String> gameResult = new HashMap<>();

        Participant participantOne = new Participant("진희", new Cards(Arrays.asList(new Card("6하트"), new Card("J다이아몬드"))));
        Participant participantTwo = new Participant("포뇨", new Cards(Arrays.asList(new Card("10스페이드"), new Card("3클로버"))));


        gameResult.put(participantOne, GameResultType.WIN.getCardType());
        gameResult.put(participantTwo, GameResultType.DRAW.getCardType());

        ParticipantGameResult participantGameResult = new ParticipantGameResult(gameResult);

        assertThat(participantGameResult.getParticipantResult(participantOne)).isEqualTo(GameResultType.WIN.getCardType());
        assertThat(participantGameResult.getParticipantResult(participantTwo)).isEqualTo(GameResultType.DRAW.getCardType());
    }
}
