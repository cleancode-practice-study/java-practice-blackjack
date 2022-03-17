package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final int INITIAL_CARD_COUNT = 2;
    public String name;
    public List<String> cards;

    public Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public static Player createPlayer(String name) {
        List<String> cards = getInitialCard(); // model 호출, player의 2장의 카드를 담은 list

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
    public static List<String> getInitialCard() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(RandomCard.getRandomCard());

        return cards;
    }
}