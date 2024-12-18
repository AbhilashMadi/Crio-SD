package game.snakeladder;

public interface IGame {
    void start();
    void playTurn();
    boolean isGameOver();
    Player getWinner();
}
