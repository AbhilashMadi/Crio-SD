package snake_game;

import java.util.LinkedList;

public class SnakeGame {
    private final LinkedList<Position> body = new LinkedList<>();
    private Direction direction;

    public SnakeGame(int size, Position initialPosition, Direction startDirection) {
        this.direction = startDirection;

        for(int i = 0; i < size; ++i) {
            this.body.add(new Position(initialPosition.x - i * startDirection.getDeltaX(), initialPosition.y - i * startDirection.getDeltaY()));
        }

    }

    private Position calculateNextHead() {
        Position head = (Position) this.body.getFirst();
        return new Position(head.x + this.direction.getDeltaX(), head.y + this.direction.getDeltaY());
    }

    public void grow() {
        Position newHead = this.calculateNextHead();
        this.body.addFirst(newHead);
    }

    public void move() {
        Position newHead = this.calculateNextHead();
        this.body.addFirst(newHead);
        this.body.removeLast();
    }

    private boolean isOppositeDirection(Direction newDirection) {
        return this.direction == Direction.UP && newDirection == Direction.DOWN || this.direction == Direction.DOWN && newDirection == Direction.UP || this.direction == Direction.LEFT && newDirection == Direction.RIGHT || this.direction == Direction.RIGHT && newDirection == Direction.LEFT;
    }

    public void setDirection(Direction newDirection) {
        if (!this.isOppositeDirection(newDirection)) {
            this.direction = newDirection;
        }

    }

    public Direction getDirection() {
        return this.direction;
    }

    public LinkedList<Position> getBody() {
        return this.body;
    }
}
