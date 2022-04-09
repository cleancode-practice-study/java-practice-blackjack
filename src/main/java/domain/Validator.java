package domain;

import java.util.Map;

public class Validator {
    public static void checkParticipantResult(Map<String, String> participantsResult, Player dealer, Player user) {
        checkWin(participantsResult, dealer, user);
        checkLose(participantsResult, dealer, user);
        checkTie(participantsResult, dealer, user);
    }

    private static void checkWin(Map<String, String> participantResult, Player dealer, Player user) {
        String name = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidUserNumber(dealer, user))
            participantResult.put(name, ResultTypes.WIN.getResultType());
    }

    private static void checkLose(Map<String, String> participantResult, Player dealer, Player user) {
        String name = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && !Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidDealerNumber(dealer, user))
            participantResult.put(name, ResultTypes.LOSE.getResultType());
    }

    private static void checkTie(Map<String, String> participantResult, Player dealer, Player user) {
        String name = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isEqualUserAndDealerNumber(dealer, user)) || Player.isNotValidDealerAndUserNumber(dealer, user))
            participantResult.put(name, ResultTypes.TIE.getResultType());
    }
}
