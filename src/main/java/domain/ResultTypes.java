package domain;

public enum ResultTypes {
    WIN("승"),
    LOSE("패"),
    TIE("무");

    private final String type;

    ResultTypes(String type) {
        this.type = type;
    }

    public String getResultType() {
        return type;
    }
}
