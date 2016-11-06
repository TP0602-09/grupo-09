package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public abstract class ConnectionRule extends Rule {

    protected INeighbourCellsRetriever neighbourCellsRetriever;

    @Override
    public boolean isValidSector(Sector sector) {
        return true;
    }

    @Override
    public boolean isValidBoard(Board board) {

        for (Sector sector : board.getSectors()) {
            for (BoardElement boardElement : sector.getBoardElements()) {
                DoubleValueCell doubleValueCell = (DoubleValueCell) boardElement;
                if (doubleValueCell.getDoubleValue() == getColor()) {
                    List<Position> positions = neighbourCellsRetriever
                            .getCellNeighboursPositions(doubleValueCell, board);
                    if (isCellConnected(board,positions)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    protected  abstract int getColor();

    protected  abstract boolean isCellConnected(Board board,
                                                List<Position> positions);
}
