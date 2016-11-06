package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class CompleteNeighbourCellsRetriever extends SimpleNeighbourCellsRetriever {

    @Override
    public List<Position> getCellNeighboursPositions(DoubleValueCell doubleValueCell, Board board) {
        List<Position> positions = super.getCellNeighboursPositions(doubleValueCell, board);
        createPositions(doubleValueCell, board,positions);
        return positions;
    }

    private void createPositions(DoubleValueCell doubleValueCell, Board board, List<Position> positions) {
        getBottomLeftPosition(doubleValueCell,positions,board);
        getBottomRightPosition(doubleValueCell,board,positions);
        getTopLeftPosition(doubleValueCell,positions);
        getTopRightPosition(doubleValueCell,board,positions);
    }



    private void getBottomRightPosition(DoubleValueCell doubleValueCell, Board board, List<Position> positions) {
        if (doubleValueCell.getPosition().getXcoordinate() + 1 <= board.getRows()
                && doubleValueCell.getPosition().getYcoordinate() + 1 <= board.getCols()) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() + 1, doubleValueCell.getPosition()
                    .getYcoordinate() + 1);
        }
    }

    private void getBottomLeftPosition(DoubleValueCell doubleValueCell, List<Position> positions, Board board) {
        if (doubleValueCell.getPosition().getYcoordinate() - 1 > 0 && doubleValueCell.getPosition()
                .getXcoordinate() + 1 <= board.getRows()) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() + 1, doubleValueCell.getPosition()
                    .getYcoordinate() - 1);
        }
    }

    private void getTopRightPosition(DoubleValueCell doubleValueCell, Board board, List<Position> positions) {
        if (doubleValueCell.getPosition().getYcoordinate() + 1 <= board.getCols()
                && doubleValueCell.getPosition().getXcoordinate() - 1 > 0) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() - 1, doubleValueCell.getPosition()
                    .getYcoordinate() + 1);
        }
    }

    private void getTopLeftPosition(DoubleValueCell doubleValueCell, List<Position> positions) {
        if (doubleValueCell.getPosition().getXcoordinate() - 1 > 0
                && doubleValueCell.getPosition().getYcoordinate() - 1 > 0) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() - 1, doubleValueCell.getPosition()
                    .getYcoordinate() - 1);
        }
    }
}