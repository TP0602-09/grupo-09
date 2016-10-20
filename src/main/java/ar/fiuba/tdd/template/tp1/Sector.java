package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Sector {

    private List<BoardElement> boardElements = new ArrayList<BoardElement>();
    private Integer value;

    public Sector(List<BoardElement> elements, Integer value) {
        this.boardElements = elements;
        this.value = value;
    }

    public List<BoardElement> getBoardElements() {
        return boardElements;
    }

    public Integer getValue() {
        return value;
    }
}
