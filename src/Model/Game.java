package Model;

/**
 * Created by mariagustina on 22/09/16.
 */
public abstract class Game {

    public Board board;

    public abstract void startConfiguration();
    public abstract void startGame();
    public abstract boolean validate(Cell cell);

}
