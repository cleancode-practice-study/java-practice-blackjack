package util;

import java.util.Random;

public class RandomCard {
    public static String getRandomCard() {
        Random random = new Random();
        String[] card = new String[2];
        String[] shapes = {"클로버", "다이아몬드", "스페이드", "하트"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "A", "J", "K", "Q"};

        int randomShapeIdx = random.nextInt(shapes.length);
        int randomNumberIdx = random.nextInt(numbers.length);

        card[0] = numbers[randomNumberIdx];
        card[1] = shapes[randomShapeIdx];

        return card[0] + card[1];
    }
}
