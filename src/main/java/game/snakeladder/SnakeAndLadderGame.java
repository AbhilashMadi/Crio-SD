package game.snakeladder;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SnakeAndLadderGame implements IGame {
    private final Board board;
    private final List<Player> players;
    private final Random random = new Random();

    private Player currentPlayer;
    private boolean isWin;

    public SnakeAndLadderGame(Board board, List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("This game requires at least 2 players.");
        }

        this.board = board;
        this.players = players;
        this.currentPlayer = players.getFirst();
    }

    public void sleepForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrupted during sleep", e);
        }
    }

    public int rollDice() {
        return random.nextInt(6) + 1;
    }

    public void moveToNextPlayer() {
        int currIndex = players.indexOf(currentPlayer);
        int nextPlayerIndex = (currIndex + 1) % players.size();
        currentPlayer = players.get(nextPlayerIndex);
    }

    @Override
    public void start() {
        System.out.println("Starting the Snake and Ladder Game...");
        Collections.shuffle(players);

        currentPlayer = players.getFirst();
        isWin = false;
    }

    @Override
    public void playTurn() {
        System.out.printf("%s is rolling the dice...\n", currentPlayer.getName());

        int rolled = rollDice();
        System.out.printf("%s rolled a %d\n", currentPlayer.getName(), rolled);

        int currentPosition = currentPlayer.getPosition();
        int newPosition = board.getNewPosition(currentPosition, rolled);

        System.out.printf("%s moved from %d to %d%n", currentPlayer.getName(), currentPosition, newPosition);

        if (newPosition == board.getBoardSize()) {
            isWin = true;
        } else {
            currentPlayer.setPosition(newPosition);
        }

        if (!isWin) {
            moveToNextPlayer();
        }

        sleepForSeconds(1);
    }

    @Override
    public boolean isGameOver() {
        return isWin;
    }

    @Override
    public Player getWinner() {
        return isWin
                ? currentPlayer
                : null;
    }
}
