package snake_game;
import java.util.Scanner;

public class SnakeDriver {
    public static void main(String[] args) {
        // Test Case 1: Initial State
        System.out.println("Test Case 1: Initial State");
        Snake snake = new Snake(3, new Position(5, 5), Direction.RIGHT);
        System.out.println("Initial Body: " + snake.getBody());
        System.out.println("Initial Direction: " + snake.getDirection());

        // Test Case 2: Modifying Direction
        System.out.println("\nTest Case 2: Modifying Direction");
        snake.setDirection(Direction.DOWN);
        System.out.println("Direction after change: " + snake.getDirection());

        // Test Case 3: Moving Snake
        System.out.println("\nTest Case 3: Moving Snake");
        snake.move();
        System.out.println("Body after moving: " + snake.getBody());

        // Test Case 4: Growing Snake
        System.out.println("\nTest Case 4: Growing Snake");
        snake.grow();
        System.out.println("Body after growing: " + snake.getBody());

        // Test Case 5: Prevent Turning Back on Itself
        System.out.println("\nTest Case 5: Prevent Turning Back on Itself");
        snake.setDirection(Direction.UP); // Should not change as current direction is DOWN
        System.out.println("Direction after trying to turn back: " + snake.getDirection());

        // Test Case 6: Moving in Different Directions
        System.out.println("\nTest Case 6: Moving in Different Directions");
        Snake snake2 = new Snake(4, new Position(2, 2), Direction.UP);
        System.out.println("Initial Body: " + snake2.getBody());
        System.out.println("Initial Direction: " + snake2.getDirection());

        snake2.move();
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        System.out.println("Body after moving in different directions: " + snake2.getBody());

        // Test Case 7: Growing and Changing Direction
        System.out.println("\nTest Case 7: Growing and Changing Direction");
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        snake2.grow();
        System.out.println("Body after moving and growing: " + snake2.getBody());

        // Test Case 8: Growing Multiple Times
        System.out.println("\nTest Case 8: Growing Multiple Times");
        snake2.grow();
        snake2.grow();
        System.out.println("Body after growing multiple times: " + snake2.getBody());

        // Test Case 9: Moving after Changing Direction
        System.out.println("\nTest Case 9: Moving after Changing Direction");
        snake2.setDirection(Direction.LEFT);
        snake2.move();
        System.out.println("Body after moving: " + snake2.getBody());
    }
}
