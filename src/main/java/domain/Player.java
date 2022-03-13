package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public static List<Player> createUserPlayers(List<String> userNames) {
        List<Player> users = new ArrayList<>();
        for (String name : userNames)
            users.add(Player.createPlayer(name));

        return users;
    }

    // 초기에 나눠주는 랜덤 카드 2장 반환 메서드
    public static List<String> getInitialCard() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(getRandomCard());

        return cards;
    }

    // 랜덤 카드 한장 반환 메서드
    public static String getRandomCard() {
        Random random = new Random();

        String[] shapes = {"클로버", "다이아몬드", "스페이드", "하트"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q"};

        int randomShapeIdx = random.nextInt(shapes.length);
        int randomNumberIdx = random.nextInt(numbers.length);

        return numbers[randomNumberIdx] + shapes[randomShapeIdx];
    }

    // 입력 받은 String, 쉼표 기준으로 String[] 반환 메서드
    public static String[] splitPlayerNames(String names) {
        return names.split(",");
    }

    public static String getAddedCommaUserNames(List<Player> users) {
        List<String> names = new ArrayList<>();
        for (Player user : users)
            names.add(user.name);

        return String.join(", ", names);
    }
}