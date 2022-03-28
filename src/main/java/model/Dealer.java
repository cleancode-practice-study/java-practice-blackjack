package model;

public class Dealer extends Player{
    public Dealer() {
        this.name = "딜러";
    }

    public boolean isEnough() {
        return getCardSum() <= 16;
    }
}
