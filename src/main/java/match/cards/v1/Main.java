package match.cards.v1;

public class Main {
    public static void main(String[] args) {
        Game cardGame = new CardGame(4);
        GameLoop gameLoop = new GameLoop(cardGame);

        gameLoop.start();
    }
}
