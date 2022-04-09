package domain;

public class Player {
    private static final int STANDARD_NUMBER = 21;
    private String name;
    private Cards cards;

    public Player(String name, Cards cards) {
        this.name = name;
        this.cards = cards;
    }

    public static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return Cards.getSum(dealer.getCards()) < Cards.getSum(user.getCards());
    }

    public String getName() {
        return this.name;
    }

    public Cards getCards() {
        return this.cards;
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

    public static boolean isEqualUserAndDealerNumber(Player dealer, Player user) {
        return Cards.getSum(dealer.getCards()) == Cards.getSum(user.getCards());
    }

    private static boolean isValidPlayerNumber(Player player) {
        return Cards.getSum(player.getCards()) <= STANDARD_NUMBER;
    }
}