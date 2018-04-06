package cardsWithPower;

public class Card implements Comparable<Card> {
    private RankPower rank;
    private SuitPower suit;

    public Card(RankPower rank, SuitPower suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getPower() {
        return this.rank.getPower() + this.suit.getPower();
    }

    public String getRankName() {
        return this.rank.name();
    }

    public String getSuitName() {
        return this.suit.name();
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.rank.name(), this.suit.name());
    }

    @Override
    public int compareTo(Card card) {
        return Integer.compare(this.getPower(), card.getPower());
    }
}
