package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class NotConnectedCellsRule extends ConnectionRule {
    private static final int BLACK = 0;

    public NotConnectedCellsRule() {
        neighbourCellsRetriever = new SimpleNeighbourCellsRetriever();
    }

    @Override
    protected int getColor() {
        return BLACK;
    }

    @Override
    protected boolean isCellConnected(Board board,List<Position> positions) {
        for (Position position : positions) {
            DoubleValueCell cell = (DoubleValueCell) board.getElement(position);
            if (cell.getDoubleValue() == BLACK) {
                return false;
            }
        }
        return true;
    }

}
