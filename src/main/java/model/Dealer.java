package model;

public class Dealer extends Participant{
    public Dealer() {
        super("딜러");
    }

    public boolean isEnough() {
        return getCardSum() <= 16;
    }
}
