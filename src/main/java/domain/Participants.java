package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<String> getParticipantNames() {
        return participants
                .stream()
                .map(Participant::getName)
                .collect(Collectors.toList());
    }
}
