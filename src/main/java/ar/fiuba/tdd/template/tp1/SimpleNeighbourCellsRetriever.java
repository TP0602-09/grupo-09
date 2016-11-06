package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignacio on 6/11/2016.
 */
public class SimpleNeighbourCellsRetriever implements INeighbourCellsRetriever {
    @Override
    public List<Position> getCellNeighboursPositions(DoubleValueCell doubleValueCell, Board board) {
        List<Position> positions = new ArrayList<>();
        getTopPosition(doubleValueCell, positions);
        getBottomPosition(doubleValueCell, board, positions);
        getLeftPosition(doubleValueCell, positions);
        getRightPosition(doubleValueCell, board, positions);
        return positions;
    }

    private void getBottomPosition(DoubleValueCell doubleValueCell, Board board, List<Position> positions) {
        if (coordinateInsideBoard(doubleValueCell.getPosition().getXcoordinate() + 1, board)) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() + 1, doubleValueCell.getPosition()
                    .getYcoordinate());
        }
    }

    private void addPositionToList(List<Position> positions, Position position) {
        positions.add(position);
    }

    private void getLeftPosition(DoubleValueCell doubleValueCell, List<Position> positions) {
        if (doubleValueCell.getPosition().getYcoordinate() - 1 > 0) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate(), doubleValueCell.getPosition()
                    .getYcoordinate() - 1);
        }
    }

    protected void createPosition(List<Position> positions, int xcoordinate, int ycoordinate) {
        Position position = new Position(xcoordinate, ycoordinate);
        addPositionToList(positions, position);
    }

    private void getRightPosition(DoubleValueCell doubleValueCell, Board board, List<Position> positions) {
        if (coordinateInsideBoard(doubleValueCell.getPosition().getYcoordinate(), board)) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate(), doubleValueCell.getPosition()
                    .getYcoordinate() + 1);
        }
    }

    private boolean coordinateInsideBoard(int coordinate, Board board) {
        return coordinate + 1 <= board.getCols();
    }

    private void getTopPosition(DoubleValueCell doubleValueCell, List<Position> positions) {
        if (doubleValueCell.getPosition().getXcoordinate() - 1 > 0) {
            createPosition(positions, doubleValueCell.getPosition().getXcoordinate() - 1, doubleValueCell.getPosition()
                    .getYcoordinate());

        }
    }
}
