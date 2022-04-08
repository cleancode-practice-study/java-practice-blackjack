package domain;

public class Player {
    private static final int STANDARD_NUMBER = 21;
    private String name;
    private Cards cards;

    public Player(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public String getName() {
        return this.name;
    }

    public static boolean isValidDealerAndUserNumber(Player dealer, Player user) {
        return isValidPlayerNumber(dealer) && isValidPlayerNumber(user);
    }

    public static boolean isNotValidDealerAndUserNumber(Player dealer, Player user) {
        return !isValidPlayerNumber(dealer) && !isValidPlayerNumber(user);
    }

    public static boolean isValidUserNumber(Player dealer, Player user) {
        return !isValidPlayerNumber(dealer) && isValidPlayerNumber(user);
    }

    public static boolean isValidDealerNumber(Player dealer, Player user) {
        return isValidPlayerNumber(dealer) && !isValidPlayerNumber(user);
    }

    public static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return Creator.getNumbersSum(dealer.getCards()) < Creator.getNumbersSum(user.getCards());
    }

    public static boolean isEqualUserAndDealerNumber(Player dealer, Player user) {
        return Creator.getNumbersSum(dealer.getCards()) == Creator.getNumbersSum(user.getCards());
    }

    public static boolean isValidPlayerNumber(Player player) {
        return Creator.getNumbersSum(player.getCards()) <= STANDARD_NUMBER;
    }

    public Cards getCards() {
        return this.cards;
    }
}