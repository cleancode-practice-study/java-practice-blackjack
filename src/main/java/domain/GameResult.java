package domain;

import java.util.Map;

public class GameResult {
    private final Map<String, String> participantsResult;
    private final Map<String, Integer> dealerResult;

    public GameResult(Map<String, String> participantsResult, Map<String, Integer> dealerResult) {
        this.participantsResult = participantsResult;
        this.dealerResult = dealerResult;
    }

    public Map<String, String> getParticipantsResult() {
        return this.participantsResult;
    }

    public Map<String, Integer> getDealerResult() {
        return this.dealerResult;
    }
}
