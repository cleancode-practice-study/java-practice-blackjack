package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static final String DEALER = "딜러";
    public static final int SPECIAL_NUMBER = 10;
    public static final int WIN_STANDARD_NUMBER = 21;
    public static final int MIN_ACE_NUMBER = 1;
    public String name;
    public List<String> cards;

    public Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public static Player createDealer() {
        List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
        return new Player(DEALER, cards);
    }

    public static List<Player> createUsers(List<String> names) {
        List<Player> users = new ArrayList<>();

        for (String name : names) {
            List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
            Player player = new Player(name, cards);
            users.add(player);
        }

        return users;
    }

    // 입력 받은 String, 쉼표 기준으로 String[] 반환 메서드
    public static String[] splitPlayerNames(String names) {
        return names.split(",");
    }

    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public int getCardTotalSum() {
        int sum = 0;

        for (String card : cards) {
            if (card.charAt(0) == 'A' && sum + SPECIAL_NUMBER > WIN_STANDARD_NUMBER) {
                sum += MIN_ACE_NUMBER;
                continue;
            } else if ((card.charAt(0) == 'A' && sum + SPECIAL_NUMBER < WIN_STANDARD_NUMBER) || card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K') {
                sum += SPECIAL_NUMBER;
                continue;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }
}

