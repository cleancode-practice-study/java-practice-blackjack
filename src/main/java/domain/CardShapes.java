package domain;

import java.util.Arrays;

public enum CardShapes {
    CLOVER(0, "클로버"),
    HEART(1, "하트"),
    DIAMOND(2, "다이아몬드"),
    SPADE(3, "스페이드");

    private final int idx;
    private final String shape;

    CardShapes(int idx, String shape) {
        this.shape = shape;
        this.idx = idx;
    }

    public static CardShapes getCardShape(int cardIdx) {
        return Arrays.stream(CardShapes.values()).filter(shape -> shape.idx == cardIdx).findAny().orElse(null);
    }

    public String getShape() {
        return this.shape;
    }
}
