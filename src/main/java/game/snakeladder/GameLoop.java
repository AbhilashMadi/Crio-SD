package game.snakeladder;

public class GameLoop {
    private final IGame game;

    public GameLoop(IGame game) {
        this.game = game;
    }

    public void start() {
        game.start();
        System.out.println("=====================================================");
        while (!game.isGameOver()) {
            game.playTurn();
            System.out.println("=====================================================");
        }
        concludeGame();
    }

    public void concludeGame() {
        Player winner = game.getWinner();

        if (winner != null) {
            System.out.printf("Game is over!\n winner: %s", winner.getName());
        }
    }
}
