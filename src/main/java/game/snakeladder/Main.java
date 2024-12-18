package game.snakeladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final Map<Integer, Integer> snakes = new HashMap<>();
        snakes.put(62, 5);
        snakes.put(33, 6);
        snakes.put(49, 9);
        snakes.put(88, 16);
        snakes.put(41, 20);
        snakes.put(56, 53);
        snakes.put(98, 64);
        snakes.put(93, 73);
        snakes.put(95, 75);

        final Map<Integer, Integer> ladders = new HashMap<>();
        ladders.put(2, 37);
        ladders.put(27, 46);
        ladders.put(10, 32);
        ladders.put(51, 68);
        ladders.put(61, 79);
        ladders.put(65, 84);
        ladders.put(71, 91);
        ladders.put(81, 100);

        final List<Player> players = new ArrayList<>();
        players.add(new Player("Gaurav"));
        players.add(new Player("Sagar"));
        players.add(new Player("Abhilash"));
        players.add(new Player("Teja"));

        Board board = new Board(100, snakes, ladders);
        IGame game = new SnakeAndLadderGame(board, players);

        GameLoop gameLoop = new GameLoop(game);
        gameLoop.start();
    }
}
