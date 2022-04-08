package domain;

import java.util.List;

public class Participants {
    private final List<Player> participants;

    public Participants(List<Player> participants) {
        this.participants = participants;
    }

    public List<Player> getParticipants() {
        return this.participants;
    }
}
