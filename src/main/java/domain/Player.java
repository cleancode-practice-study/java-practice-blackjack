package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {
    public static final String DEALER = "딜러";
    public static final int SPECIAL_NUMBER = 10;
    public static final int WIN_STANDARD_NUMBER = 21;
    public static final int MIN_ACE_NUMBER = 1;
    public static final char ACE = 'A';
    public static final char JACK = 'J';
    public static final char QUEEN = 'Q';
    public static final char KING = 'K';
    private static final String LOSE = "패";
    public String name;
    public List<String> cards;

    public Player(String playerName, List<String> playerCards) {
        this.name = playerName;
        this.cards = playerCards;
    }

    public static Player createPlayer(String name) {
        List<String> cards = RandomCard.getInitialCard(); // model 호출, player의 2장의 카드를 담은 list

        return new Player(name, cards);
    }

    public static List<Player> createUserPlayers(List<String> names) {
        List<Player> users = new ArrayList<>();

        for (String name : names)
            users.add(Player.createPlayer(name)); // 카드가 부여된 USER 플레이어 생성

        return users;
    }

    // 입력 받은 String, 쉼표 기준으로 String[] 반환 메서드
    public static String[] splitPlayerNames(String names) {
        return names.split(",");
    }

    // 수정 필요 - indent 2개
    // 딜러 win count 구하는 메서드
    public static int getDealerWinCounter(Map<String, String> map) {
        int winCount = 0;
        for (Map.Entry<String, String> value : map.entrySet()) {
            if (value.getValue().equals(LOSE))
                winCount++;
        }
        return winCount;
    }

    // 수정 필요 - indent 2개
    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public int getCardTotalSum() {
        int sum = 0;

        for (String card : cards) {
            if (card.charAt(0) == ACE && sum + SPECIAL_NUMBER > WIN_STANDARD_NUMBER) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if ((card.charAt(0) == ACE && sum + SPECIAL_NUMBER < WIN_STANDARD_NUMBER) || card.charAt(0) == JACK || card.charAt(0) == QUEEN || card.charAt(0) == KING) {
                sum += SPECIAL_NUMBER;
                continue;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }
}