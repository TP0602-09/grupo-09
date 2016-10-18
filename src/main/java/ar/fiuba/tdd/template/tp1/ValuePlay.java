package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 17/10/2016.
 */
public class ValuePlay implements Play {

    private Position position;
    private Integer value;

    public ValuePlay(Position position, Integer value) {
        this.position = position;
        this.value = value;
    }

    @Override
    public void doIt(Board board) {
        //TODO implement method
    }
}
