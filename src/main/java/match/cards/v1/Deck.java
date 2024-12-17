package match.cards.v1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();

        // Initialize the deck with 52 cards
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Shuffles the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draws the top card from the deck
    public Card draw() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.remove(cards.size() - 1); // Drawing from the top/end of the list
    }

    // Returns the number of cards left in the deck
    public int cardsLeft() {
        return cards.size();
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}