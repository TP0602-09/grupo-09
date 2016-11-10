package ar.fiuba.tdd.template.tp1;

import java.util.List;

public class Sector {

    private List<BoardElement> boardElements;
    private int value;

    public Sector(List<BoardElement> elements, int value) {
        this.boardElements = elements;
        this.value = value;
    }

    public Sector(List<BoardElement> elements) {
        this.boardElements = elements;
        this.value = 0;
    }

    public List<BoardElement> getBoardElements() {
        return boardElements;
    }

    public int getValue() {
        return value;
    }
}
