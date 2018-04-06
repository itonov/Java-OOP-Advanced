package cardsWithPower;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> cards;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Card> getCards() {
        return this.cards;
    }

    public void addCard(Card card) {
        for (Card cardInHand : this.cards) {
            if (cardInHand.getRankName().equalsIgnoreCase(card.getRankName())
                    && cardInHand.getSuitName().equalsIgnoreCase(card.getSuitName())) {
                throw new IllegalArgumentException("Card is not in the deck.");
            }
        }
        this.cards.add(card);
    }
}


