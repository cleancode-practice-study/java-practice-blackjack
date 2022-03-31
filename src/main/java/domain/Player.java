package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int STANDARD_NUMBER = 21;
    private static final int INITIAL_CARD_COUNT = 2;
    private String name;
    private List<String> cards;

    private Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getCards() {
        return this.cards;
    }

    public static Player createPlayer(String name) {
        List<String> cards = getInitialCards(); // model 호출, player의 2장의 카드를 담은 list

        return new Player(name, cards);
    }

    public static List<Player> createUserPlayers(List<String> names) {
        List<Player> users = new ArrayList<>();
        for (String name : names) {
            Player user = createPlayer(name);
            users.add(user);
        }

        return users;
    }

    // 초기에 나눠주는 랜덤 카드 2장 반환 메서드
    public static List<String> getInitialCards() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(Card.getRandomOneCard());

        return cards;
    }

    static boolean isValidDealerAndUserNumber(Player dealer, Player user) {
        return isValidPlayerNumber(dealer) && isValidPlayerNumber(user);
    }

    static boolean isNotValidDealerAndUserNumber(Player dealer, Player user) {
        return !isValidPlayerNumber(dealer) && !isValidPlayerNumber(user);
    }

    static boolean isValidUserNumber(Player dealer, Player user) {
        return !isValidPlayerNumber(dealer) && isValidPlayerNumber(user);
    }

    static boolean isValidDealerNumber(Player dealer, Player user) {
        return isValidPlayerNumber(dealer) && !isValidPlayerNumber(user);
    }

    static boolean isLargerThanDealerNumber(Player dealer, Player user) {
        return Result.getSumNumber(dealer.getCards()) < Result.getSumNumber(user.getCards());
    }

    static boolean isEqualUserNumberAndDealerNumber(Player dealer, Player user) {
        return Result.getSumNumber(dealer.getCards()) == Result.getSumNumber(user.getCards());
    }

    private static boolean isValidPlayerNumber(Player player) {
        return Result.getSumNumber(player.getCards()) <= STANDARD_NUMBER;
    }
}