package domain;

import java.util.Random;

public class RandomCard {
    // 랜덤 카드 한장 반환 메서드
    public static String getRandomCard() {
        Random random = new Random();

        String[] shapes = {"클로버", "다이아몬드", "스페이드", "하트"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q"};

        int randomShapeIdx = random.nextInt(shapes.length);
        int randomNumberIdx = random.nextInt(numbers.length);

        return numbers[randomNumberIdx] + shapes[randomShapeIdx];
    }
}
