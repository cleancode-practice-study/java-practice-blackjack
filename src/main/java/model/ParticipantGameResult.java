package model;

import java.util.Map;
import java.util.Set;

public class ParticipantGameResult {
    Map<Participant, String> gameResult;

    public ParticipantGameResult (Map<Participant, String> gameResult) {
        this.gameResult = gameResult;
    }

    public Set<Participant> getKeySet() {
        return gameResult.keySet();
    }

    public String getParticipantResult(Participant participant) {
        return gameResult.get(participant);
    }
}
