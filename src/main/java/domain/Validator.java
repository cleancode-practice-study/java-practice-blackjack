package domain;

import java.util.Map;


public class Validator {
    public static void checkParticipantResult(Map<String, String> participantsResult, Player dealer, Player user) {
        checkWin(participantsResult, dealer, user);
        checkLose(participantsResult, dealer, user);
        checkTie(participantsResult, dealer, user);
    }

    private static void checkWin(Map<String, String> participantsResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidUserNumber(dealer, user))
            participantsResult.put(userName, ResultTypes.WIN.getResultType());
    }

    private static void checkLose(Map<String, String> participantsResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && !Player.isLargerThanDealerNumber(dealer, user)) || Player.isValidDealerNumber(dealer, user))
            participantsResult.put(userName, ResultTypes.LOSE.getResultType());
    }

    private static void checkTie(Map<String, String> participantsResult, Player dealer, Player user) {
        String userName = user.getName();

        if ((Player.isValidDealerAndUserNumber(dealer, user) && Player.isEqualUserAndDealerNumber(dealer, user)) || Player.isNotValidDealerAndUserNumber(dealer, user))
            participantsResult.put(userName, ResultTypes.TIE.getResultType());
    }
}
