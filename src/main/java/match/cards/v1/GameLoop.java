package match.cards.v1;

public class GameLoop {
    private final Game game;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void start() {
        game.start();
        System.out.println("=========================================\n");
        while (!game.isGameOver()) {
            game.playTurn();
            System.out.println("=========================================\n");
        }
        concludeGame();
    }

    private void concludeGame() {
        Player winner = game.getWinner();
        if (winner != null) {
            System.out.println("IGame Over! Winner: " + winner.getName());
        } else {
            System.out.println("IGame Over! It's a draw.");
        }
    }
}