package domain;

public enum GameResultType {
    WIN("승"),
    LOSE("패"),
    DRAW("무");

    private final String resultType;

    public String getCardType() {
        return resultType;
    }

    private GameResultType(String resultType) {
        this.resultType = resultType;
    }
}
