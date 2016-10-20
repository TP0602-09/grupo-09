package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Lucía on 20/10/2016.
 */
public class OutputData {

    private List<Play> plays;
    private OutputBoard board;

    public OutputData() {}

    public List<Play> getPlays() {
        return plays;
    }

    public OutputBoard getBoard() {
        return board;
    }

    public void setPlays(List<Play> plays) {
        this.plays = plays;
    }

    public void setBoard(OutputBoard board) {
        this.board = board;
    }
}
