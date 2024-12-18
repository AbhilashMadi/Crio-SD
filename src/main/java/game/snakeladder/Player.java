package game.snakeladder;

import java.util.Objects;

public class Player {
    private final String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Player other = (Player) obj;
        return Objects.equals(other.getName(), name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int res = 17;

        res = res * prime + (this.name != null ? name.hashCode() : 0);
        return res;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", position=" + position +
                '}';
    }
}
