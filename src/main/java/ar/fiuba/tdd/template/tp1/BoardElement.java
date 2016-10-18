package ar.fiuba.tdd.template.tp1;


/**
 * Created by Lucía on 16/10/2016.
 */
public abstract class BoardElement {

    protected Position position;

    public BoardElement (Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
