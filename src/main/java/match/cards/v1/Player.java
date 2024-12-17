package match.cards.v1;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // Receives a card (from drawing or being dealt one)
    public void receiveCard(Card card) {
        hand.add(card);
    }

    // Plays a card from the hand
    public Card playCard(Card card) {
        if (!hand.contains(card)) {
            throw new IllegalArgumentException("Player doesn't have this card in hand.");
        }
        hand.remove(card);
        return card;
    }

    // Gets the player's name
    public String getName() {
        return name;
    }

    // Returns the player's hand
    public List<Card> getHand() {
        return hand;
    }

    // Used to display the player's hand
    @Override
    public String toString() {
        return name + "'s hand: " + hand.toString();
    }

    public boolean isHandEmpty()
    {
        if(this.hand == null)
            return true;
        else
            return false;
    }
}