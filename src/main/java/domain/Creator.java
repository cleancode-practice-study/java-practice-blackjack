package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Creator {
    public static List<Player> createParticipants(List<String> names) {
        return names.stream().map(name -> new Player(name, Cards.getInitialCards())).collect(Collectors.toList());
    }

    public static Map<String, Integer> getDealerResult(Map<String, String> participantsResult) {
        Map<String, Integer> dealerResult = new HashMap<String, Integer>() {
            {
                put(ResultTypes.WIN.getResultType(), 0);
                put(ResultTypes.LOSE.getResultType(), 0);
                put(ResultTypes.TIE.getResultType(), 0);
            }
        };

        List<String> result = new ArrayList<>();
        for (String userName : participantsResult.keySet())
            result.add(participantsResult.get(userName));

        for (String str : result)
            dealerResult.put(str, dealerResult.getOrDefault(str, 0) + 1);

        return dealerResult;
    }

    public static Map<String, String> getParticipantsResult(Player dealer, Participants participants) {
        Map<String, String> participantsResult = new HashMap<>();

        for (Player user : participants.getParticipants())
            Validator.checkParticipantResult(participantsResult, dealer, user);

        return participantsResult;
    }
}
