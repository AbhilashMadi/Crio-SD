package snake_game;

import java.util.LinkedList;
import snake_game.Position;
import snake_game.Direction;

public class Snake {
    final private LinkedList<Position> body;
    private Direction direction;

    public Snake(int size, Position startPosition, Direction startDirection) {
        this.body = new LinkedList<>();
        this.direction = startDirection;

        int x = startPosition.x;
        int y = startPosition.y;

        for (int i = 0; i < size; i++) {
            this.body.add(new Position(x, y));
            switch (startDirection) {
                case RIGHT -> x--;  // Extend to the left for RIGHT
                case LEFT -> x++;   // Extend to the right for LEFT
                case UP -> y++;     // Extend downward for UP
                case DOWN -> y--;   // Extend upward for DOWN
            }
        }
    }

    public LinkedList<Position> getBody() {
        return this.body;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(Direction newDirection) {
        // Prevents the snake from reversing on itself.
        if ((newDirection == Direction.UP && direction == Direction.DOWN)
                || (newDirection == Direction.DOWN && direction == Direction.UP)
                || (newDirection == Direction.LEFT && direction == Direction.RIGHT)
                || (newDirection == Direction.RIGHT && direction == Direction.LEFT)) {
            return;
        }
        this.direction = newDirection;
    }

    public void move() {
        Position head = body.getFirst();
        Position newHead = getNextPosition(head);
        body.addFirst(newHead);
        body.removeLast();
    }

    public void grow() {
        Position head = body.getFirst();
        Position newHead = getNextPosition(head);
        body.addFirst(newHead);
    }

    private Position getNextPosition(Position currentHead) {
        return switch (direction) {
            case UP -> new Position(currentHead.x, currentHead.y + 1);
            case DOWN -> new Position(currentHead.x, currentHead.y - 1);
            case LEFT -> new Position(currentHead.x - 1, currentHead.y);
            case RIGHT -> new Position(currentHead.x + 1, currentHead.y);
        };
    }
}