package model;

import java.util.ArrayList;
import java.util.List;

public class Participants {
    List<Participant> participants;

    public Participants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<String> getParticipantNames() {
        List<String> names = new ArrayList<>();

        for (Participant participant : participants) {
            names.add(participant.getName());
        }

        return names;
    }
}
