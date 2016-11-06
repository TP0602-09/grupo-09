package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class CellsConnectedRule extends ConnectionRule {
    private static final int BLACK = 0;
    private static  final int WHITE = 1;

    public CellsConnectedRule() {
        neighbourCellsRetriever = new CompleteNeighbourCellsRetriever();
    }

    @Override
    protected int getColor() {
        return WHITE;
    }

    @Override
    protected boolean isCellConnected(Board board, List<Position> positions) {
        int count = 0;
        for (Position position : positions) {
            DoubleValueCell cell = (DoubleValueCell) board.getElement(position);
            if (cell.getDoubleValue() == BLACK) {
                count++;
            }
        }
        return count < positions.size();
    }


}
