package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCard {

    public static final int INITIAL_CARD_COUNT = 2;

    // 랜덤 카드 한장 반환 메서드
    public static String getRandomCard() {
        Random random = new Random();

        String[] shapes = {"클로버", "다이아몬드", "스페이드", "하트"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q"};

        int randomShapeIdx = random.nextInt(shapes.length);
        int randomNumberIdx = random.nextInt(numbers.length);

        return numbers[randomNumberIdx] + shapes[randomShapeIdx];
    }

    // 초기에 나눠주는 랜덤 카드 2장 반환 메서드
    public static List<String> getInitialCard() {
        List<String> cards = new ArrayList<>();

        for (int i = 0; i < INITIAL_CARD_COUNT; i++)
            cards.add(getRandomCard());

        return cards;
    }

}
