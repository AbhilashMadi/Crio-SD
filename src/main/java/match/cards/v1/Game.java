package match.cards.v1;

public interface Game {
    void start();
    void playTurn();
    boolean isGameOver();
    Player getWinner();
}