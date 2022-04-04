package domain;

public abstract class Player {
    protected Cards cards;
    protected String name;

    public String getName() {
        return name;
    }

    public Cards getCards() { return cards; }

    public void receiveCard() {
        Card card = RandomCardCreator.getRandomCard();
        cards.addCard(card);
    }

}
