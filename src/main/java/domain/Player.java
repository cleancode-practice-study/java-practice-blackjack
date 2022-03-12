package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Player {
    public static final int SPECIAL_NUMBER = 10;
    public static final int WIN_STANDARD_NUMBER = 21;
    public static final int MIN_ACE_NUMBER = 1;
    public static final int INITIAL_CARD_COUNT = 2;
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

    private static boolean isSpecialNumber(String card, int sum) {
        return isAceCard(card) && isSmallThanWinStandardNumber(card, sum) || isJackAndQueenAndKing(card);
    }

    private static boolean isMinAceNumber(String card, int sum) {
        return card.charAt(0) == ACE && sum + SPECIAL_NUMBER > WIN_STANDARD_NUMBER;
    }

    private static boolean isJackAndQueenAndKing(String card) {
        return card.charAt(0) == JACK || card.charAt(0) == QUEEN || card.charAt(0) == KING;
    }

    private static boolean isAceCard(String card) {
        return card.charAt(0) == ACE;
    }

    private static boolean isSmallThanWinStandardNumber(String card, int sum) {
        return sum + SPECIAL_NUMBER < WIN_STANDARD_NUMBER;
    }

    // 수정 필요 - indent 2개
    // 가지고 있는 카드의 숫자 합계 반환 메서드
    public int getCardTotalSum() {
        int sum = 0;

        for (String card : cards) {
            if (isMinAceNumber(card, sum)) {
                sum += MIN_ACE_NUMBER;
                continue;
            }

            if (isSpecialNumber(card, sum)) {
                sum += SPECIAL_NUMBER;
                continue;
            }

            sum += Character.getNumericValue(card.charAt(0));
        }

        return sum;
    }
}