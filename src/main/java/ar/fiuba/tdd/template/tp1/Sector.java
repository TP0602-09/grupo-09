package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Sector {

    private List<BoardElement> boardElements;
    private Integer value;

    public Sector(List<BoardElement> boardElements, Integer value) {
        this.boardElements = boardElements;
        this.value = value;
    }

    public List<BoardElement> getBoardElements() {
        return boardElements;
    }

}
