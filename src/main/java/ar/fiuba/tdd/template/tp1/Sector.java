package ar.fiuba.tdd.template.tp1;

import java.util.List;

public class Sector {

    private List<BoardElement> boardElements;
    private int value;

    public Sector(List<BoardElement> boardElements, Integer value) {
        this.boardElements = boardElements;
        this.value = value;
    }

    public List<BoardElement> getBoardElements() {
        return boardElements;
    }

    public int getValue() {
        return value;
    }
}
