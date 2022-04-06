package domain;

import java.util.Map;
import java.util.Set;

public class ParticipantGameResult {
    Map<Participant, GameResultType> gameResult;

    public ParticipantGameResult (Map<Participant, GameResultType> gameResult) {
        this.gameResult = gameResult;
    }

    public Set<Participant> getKeySet() {
        return gameResult.keySet();
    }

    public GameResultType getParticipantResult(Participant participant) {
        return gameResult.get(participant);
    }
}
