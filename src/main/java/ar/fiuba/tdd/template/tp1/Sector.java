package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Sector {

    private List<BoardElement> boardElements;

    public Sector(List<BoardElement> boardElements) {
        this.boardElements = boardElements;
    }

    public List<BoardElement> getBoardElements() {
        return boardElements;
    }

}
