package domain;

import java.util.Map;

public class Validator {
    private static final int STANDARD_NUMBER = 21;
    public static final String WIN = "승";
    public static final String LOSE = "패";
    public static final String TIE = "무";
    public static final char ACE = 'A';
    public static final char JACK = 'J';
    public static final char QUEEN = 'Q';
    public static final char KING = 'K';
    public static final int TEN = 10;

    static void checkUserWin(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && isLargerThanDealerNumber(dealer, user)) || isValidUserNumber(dealer, user))
            userWinOrLoseResult.put(userName, WIN);
    }

    static void checkUserLose(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && !isLargerThanDealerNumber(dealer, user)) || isValidDealerNumber(dealer, user))
            userWinOrLoseResult.put(userName, LOSE);
    }

    static void checkUserTie(Map<String, String> userWinOrLoseResult, Player dealer, Player user) {
        String userName = user.name;

        if ((isValidDealerAndUserNumber(dealer, user) && isEqualUserNumberAndDealerNumber(dealer, user)) || isNotValidDealerAndUserNumber(dealer, user))
            userWinOrLoseResult.put(userName, TIE);
    }

    private static boolean isValidDealerAndUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return isValidDealerResult && isValidUserResult;
    }

    private static boolean isNotValidDealerAndUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return !isValidDealerResult && !isValidUserResult;
    }

    private static boolean isValidUserNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return !isValidDealerResult && isValidUserResult;
    }

    private static boolean isValidDealerNumber(Player dealer, Player user) {
        boolean isValidDealerResult = isValidPlayerNumber(dealer);
        boolean isValidUserResult = isValidPlayerNumber(user);

        return isValidDealerResult && !isValidUserResult;
    }

    private static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return Result.getResultNumber(dealer.cards) < Result.getResultNumber(user.cards);
    }

    private static boolean isEqualUserNumberAndDealerNumber(Player dealer, Player user) {
        return Result.getResultNumber(dealer.cards) == Result.getResultNumber(user.cards);
    }

    private static boolean isValidPlayerNumber(Player player) {
        return Result.getResultNumber(player.cards) <= STANDARD_NUMBER;
    }

    static boolean isMinAceNumber(char number, int sum) {
        return isAceCard(number) && sum + TEN > STANDARD_NUMBER;
    }

    static boolean isMaxAceNumber(char number, int sum) {
        return isAceCard(number) && sum + TEN <= STANDARD_NUMBER;
    }

    static boolean isTenNumber(char number) {
        return isJackAndQueenAndKingCard(number);
    }

    private static boolean isJackAndQueenAndKingCard(char number) {
        return isJackCard(number) || isQueenCard(number) || isKingCard(number);
    }

    private static boolean isAceCard(char number) {
        return number == ACE;
    }

    private static boolean isJackCard(char number) {
        return number == JACK;
    }

    private static boolean isQueenCard(char number) {
        return number == QUEEN;
    }

    private static boolean isKingCard(char number) {
        return number == KING;
    }
}
