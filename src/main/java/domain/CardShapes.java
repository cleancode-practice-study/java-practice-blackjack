package domain;

public enum CardShapes {
    클로버(0, "클로버"),
    하트(1, "하트"),
    다이아몬드(2, "다이아몬드"),
    스페이드(3, "스페이드");

    private static int count = 0;
    private final int idx;
    private final String shape;

    CardShapes(int idx, String shape) {
        this.shape = shape;
        this.idx = idx;
    }

    public static String getShape(int cardIdx) {
        for (CardShapes cardShapes : CardShapes.values()) {
            if (cardIdx == cardShapes.idx)
                return cardShapes.shape;
        }
        return null;
    }

}
