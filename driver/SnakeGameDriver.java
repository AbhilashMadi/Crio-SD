package snake_game;

public class SnakeGameDriver {
    public SnakeGameDriver() {
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: Initial State");
        SnakeGame snake = new SnakeGame(3, new Position(5, 5), Direction.RIGHT);
        System.out.println("Initial Body: " + String.valueOf(snake.getBody()));
        System.out.println("Initial Direction: " + String.valueOf(snake.getDirection()));
        System.out.println("\nTest Case 2: Modifying Direction");
        snake.setDirection(Direction.DOWN);
        System.out.println("Direction after change: " + String.valueOf(snake.getDirection()));
        System.out.println("\nTest Case 3: Moving Snake");
        snake.move();
        System.out.println("Body after moving: " + String.valueOf(snake.getBody()));
        System.out.println("\nTest Case 4: Growing Snake");
        snake.grow();
        System.out.println("Body after growing: " + String.valueOf(snake.getBody()));
        System.out.println("\nTest Case 5: Prevent Turning Back on Itself");
        snake.setDirection(Direction.UP);
        System.out.println("Direction after trying to turn back: " + String.valueOf(snake.getDirection()));
        System.out.println("\nTest Case 6: Moving in Different Directions");
        SnakeGame snake2 = new SnakeGame(4, new Position(2, 2), Direction.UP);
        System.out.println("Initial Body: " + String.valueOf(snake2.getBody()));
        System.out.println("Initial Direction: " + String.valueOf(snake2.getDirection()));
        snake2.move();
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        System.out.println("Body after moving in different directions: " + String.valueOf(snake2.getBody()));
        System.out.println("\nTest Case 7: Growing and Changing Direction");
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        snake2.grow();
        System.out.println("Body after moving and growing: " + String.valueOf(snake2.getBody()));
        System.out.println("\nTest Case 8: Growing Multiple Times");
        snake2.grow();
        snake2.grow();
        System.out.println("Body after growing multiple times: " + String.valueOf(snake2.getBody()));
        System.out.println("\nTest Case 9: Moving after Changing Direction");
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        System.out.println("Body after moving: " + String.valueOf(snake2.getBody()));
    }
}
