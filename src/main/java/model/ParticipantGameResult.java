package model;

import java.util.Map;
import java.util.Set;

public class ParticipantGameResult {
    Map<String, String> gameResult;

    public ParticipantGameResult (Map<String, String> gameResult) {
        this.gameResult = gameResult;
    }

    public Set<String> getKeySet() {
        return gameResult.keySet();
    }

    public String getParticipantResult(String name) {
        return gameResult.get(name);
    }
}
