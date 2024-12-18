package game.snakeladder;

import java.util.Map;

public class Board {
    private final int boardSize;
    private final Map<Integer, Integer> snakes;
    private final Map<Integer, Integer> ladders;

    public Board(int boardSize, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        this.boardSize = boardSize;
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int getNewPosition(int currentPosition, int diceRoll){
        int newPosition = currentPosition + diceRoll;

        // If the new position out of size of the board don't move
        if(newPosition > boardSize){
            return currentPosition;
        }

        // If the new position in snakes or ladders based on it new new position
        while(snakes.containsKey(newPosition) || ladders.containsKey(newPosition)){
            if(snakes.containsKey(newPosition)){
                newPosition = snakes.get(newPosition);
            }else if(ladders.containsKey(newPosition)){
                newPosition = ladders.get(newPosition);
            }
        }

        return newPosition;
    }

    public boolean isWinningPosition(int position){
        return position == boardSize;
    }

    public int getBoardSize(){
        return boardSize;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardSize=" + boardSize +
                ", snakes=" + snakes +
                ", ladders=" + ladders +
                '}';
    }
}
