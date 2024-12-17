package match.cards.v1;

import java.util.ArrayList;
import java.util.List;

public class CardGame implements Game {
    private final List<Player> players;
    private final Deck deck;
    private final List<Card> discardPile;
    private Player currentPlayer;
    private Card lastActionCardPlayed;
    private boolean reverseOrder = false;
    private boolean shouldEndGame = false;

    public CardGame(int numberOfPlayers) {
        // Validate the number of players during game initialization
        if (numberOfPlayers < 2 || numberOfPlayers > 4) {
            throw new IllegalArgumentException("Game supports 2 to 4 players only.");
        }

        this.players = new ArrayList<>();
        this.deck = new Deck();
        this.discardPile = new ArrayList<>();
        // Initialize players with names
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player("Player " + (i + 1)));
        }
    }

    @Override
    public void start() {
        System.out.println("Starting Game...");
        System.out.println("Shuffling Cards...");
        deck.shuffle();

        // Deal initial cards to all players
        System.out.println("Dealing cards to all Players...");
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.receiveCard(deck.draw());
            }
        }

        // Initial card to start the game
        System.out.println("Drawing first card...");
        Card firstCard = deck.draw();
        // Update the last action card played if the first card is an action card
        if (firstCard.isActionCard()) {
            lastActionCardPlayed = firstCard;
        }
        discardPile.add(firstCard);
        currentPlayer = players.get(0);
    }

    @Override
    public void playTurn() {
        Card topDiscard = discardPile.get(discardPile.size() - 1);
        System.out.println("Top card: " + topDiscard);
        System.out.println(currentPlayer.getName()+ "'s turn.");
        System.out.println(currentPlayer+"\n");

        boolean hasPlayableCard = playPlayableCard(topDiscard);

        if (!hasPlayableCard) {
            System.out.println(currentPlayer.getName() + " cannot play. Drawing a card...");
            if (deck.cardsLeft() == 0) {
                System.out.println("No cards left to draw. Ending game.");
                shouldEndGame = true;
                return;
            }
            currentPlayer.receiveCard(deck.draw());
            System.out.println(currentPlayer);
            moveToNextPlayer();
        }
        sleepForOneSecond();
    }

    // Check if the player has a playable card and play it
    private boolean playPlayableCard(Card topDiscard) {
        for (Card cardInHand : currentPlayer.getHand()) {
            if (isCardPlayable(cardInHand, topDiscard) && !isConsecutiveActionCard(cardInHand)) {
                System.out.println(currentPlayer.getName() + " played: " + cardInHand);
                playCard(cardInHand);
                return true;
            }
        }
        return false;
    }

    // Check if a card is playable (matching suit or rank)
    private boolean isCardPlayable(Card card, Card topDiscard) {
        return card.getSuit() == topDiscard.getSuit() || card.getRank() == topDiscard.getRank();
    }

    // Check if the card being played is an action card played consecutively
    private boolean isConsecutiveActionCard(Card card) {
        return card.isActionCard() && lastActionCardPlayed != null && card.getRank() == lastActionCardPlayed.getRank();
    }

    // Simulate a pause between turns
    private void sleepForOneSecond() {
        try {
            Thread.sleep(1000); // Sleep for a second to simulate some time between turns
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Play a card, apply effects, and move to the next player
    private void playCard(Card chosenCard) {

        currentPlayer.playCard(chosenCard);
        discardPile.add(chosenCard);

        if (chosenCard.isActionCard()) {
            lastActionCardPlayed = chosenCard;
            applySpecialCardEffects(chosenCard);
        }else{
            lastActionCardPlayed = null; // Reset if it's a non-action card
        }
        moveToNextPlayer();
    }


    private void applySpecialCardEffects(Card chosenCard) {

        switch (chosenCard.getRank()) {
            case ACE:
            {
                moveToNextPlayer();
                System.out.println(currentPlayer.getName() + "'s turn skipped.");
                break;
            }
            case KING:
            {
                reverseOrder = !reverseOrder;
                System.out.println("Game turn order reversed!");
                break;
            }
            case QUEEN:
            {
                int currentIndex = players.indexOf(currentPlayer);
                if (reverseOrder) {
                    currentIndex = (currentIndex - 1 + players.size()) % players.size();
                } else {
                    currentIndex = (currentIndex + 1) % players.size();
                }
                Player nextPlayer = players.get(currentIndex);
                System.out.println(nextPlayer);
                if (deck.cardsLeft() < 2) {
                    System.out.println("No cards left to draw. Ending game.");
                    shouldEndGame = true;
                    return;
                }
                for (int i = 0; i < 2; i++) {
                    nextPlayer.receiveCard(deck.draw());
                }
                System.out.println(nextPlayer.getName() + " drawing 2 cards...");
                System.out.println(nextPlayer);
                break;
            }
            case JACK:
            {
                int currentIndex = players.indexOf(currentPlayer);
                if (reverseOrder) {
                    currentIndex = (currentIndex - 1 + players.size()) % players.size();
                } else {
                    currentIndex = (currentIndex + 1) % players.size();
                }
                Player nextPlayer = players.get(currentIndex);
                System.out.println(nextPlayer);
                if (deck.cardsLeft() < 4) {
                    System.out.println("No cards left to draw. Ending game.");
                    shouldEndGame = true;
                    return;
                }
                for (int i = 0; i < 4; i++) {
                    nextPlayer.receiveCard(deck.draw());
                }
                System.out.println(nextPlayer.getName() + " drawing 4 cards...");
                System.out.println(nextPlayer);
                break;
            }
            default:
                break;
        }
    }

    // Move to the next player based on the game's order
    private void moveToNextPlayer() {
        int currentIndex = players.indexOf(currentPlayer);
        if (reverseOrder) {
            currentIndex = (currentIndex - 1 + players.size()) % players.size();
        } else {
            currentIndex = (currentIndex + 1) % players.size();
        }
        currentPlayer = players.get(currentIndex);
    }

    @Override
    public boolean isGameOver() {
        return shouldEndGame || players.stream().anyMatch(Player::isHandEmpty);
    }

    @Override
    public Player getWinner() {
        return players.stream().filter(Player::isHandEmpty).findFirst().orElse(null);
    }
}