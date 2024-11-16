package snake_game;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Position position = (Position)o;
            return this.x == position.x && this.y == position.y;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return 31 * this.x + this.y;
    }
}
