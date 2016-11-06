package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public interface INeighbourCellsRetriever {
    public List<Position>  getCellNeighboursPositions(DoubleValueCell doubleValueCell, Board board);
}
