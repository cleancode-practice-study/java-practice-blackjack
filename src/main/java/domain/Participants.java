package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Participants {
    private final List<Player> participants;

    public Participants(List<Player> participants) {
        this.participants = participants;
    }

    public List<Player> getParticipants() {
        return this.participants;
    }

    public static List<Player> create(List<String> names) {
        return names.stream()
                .map(name -> new Player(name, Cards.getInitialCards()))
                .collect(Collectors.toList());
    }
}
