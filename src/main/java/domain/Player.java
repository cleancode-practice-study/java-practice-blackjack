package domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public String name;
    public List<String> cards;

    public Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public static Player createDealer() {
        List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
        return new Player("딜러", cards);
    }

    public static List<Player> createUsers(List<String> names) {
        List<Player> players = new ArrayList<>();

        for (String name : names) {
            List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list
            Player player = new Player(name, cards);
            players.add(player);
        }

        return players;
    }

    // 입력 받은 String, 쉼표 기준으로 String[] 반환 메서드
    public static String[] splitPlayerNames(String names) {
        return names.split(",");
    }

    // Ace의 number 계산 메서드(1 또는 11)
    private static int getAceNumber(int sum) {
        if (sum + 10 > 21) {
            return 1;
        } else {
            return 10;
        }
    }

    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public int getCardTotalSum() {
        int sum = 0;

        for (String card : cards) {
            if (card.charAt(0) == 'A') {
                sum += getAceNumber(sum);
                continue;
            } else if (card.charAt(0) == 'J' || card.charAt(0) == 'Q' || card.charAt(0) == 'K') {
                sum += 10;
                continue;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }
}

