package match.cards.v1;

public class Card {
    public enum Suit {
        HEARTS("H"), DIAMONDS("D"), CLUBS("C"), SPADES("S");

        private final String emoji;

        Suit(String emoji) {
            this.emoji = emoji;
        }

        public String getEmoji() {
            return emoji;
        }
    }

    public enum Rank {
        TWO("2"),
        THREE("3"),
        FOUR("4"),
        FIVE("5"),
        SIX("6"),
        SEVEN("7"),
        EIGHT("8"),
        NINE("9"),
        TEN("10"),
        JACK("JACK"),
        QUEEN("QUEEN"),
        KING("KING"),
        ACE("ACE");
        private final String emoji;

        Rank(String emoji) {
            this.emoji = emoji;
        }

        public String getEmoji() {
            return emoji;
        }
    }

    private final Suit suit;
    private final Rank rank;
    private final boolean isActionCard;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.isActionCard = (rank == Rank.ACE || rank == Rank.QUEEN || rank == Rank.KING || rank == Rank.JACK);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isActionCard(){
        return isActionCard;
    }

    @Override
    public String toString() {
        return rank.getEmoji() + "~" + suit.getEmoji();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((suit == null) ? 0 : suit.hashCode());
        result = prime * result + ((rank == null) ? 0 : rank.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (suit != other.suit)
            return false;
        if (rank != other.rank)
            return false;
        return true;
    }
}