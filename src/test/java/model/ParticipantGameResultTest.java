package model;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantGameResultTest {
    @Test
    public void 참가자_게임_결과_확인() {
        Map<String, String> gameResult = new HashMap<>();

        gameResult.put("진희", GameResultType.WIN.getCardType());
        gameResult.put("포뇨", GameResultType.DRAW.getCardType());

        ParticipantGameResult participantGameResult = new ParticipantGameResult(gameResult);

        assertThat(participantGameResult.getParticipantResult("진희")).isEqualTo(GameResultType.WIN.getCardType());
        assertThat(participantGameResult.getParticipantResult("포뇨")).isEqualTo(GameResultType.DRAW.getCardType());
    }
}
