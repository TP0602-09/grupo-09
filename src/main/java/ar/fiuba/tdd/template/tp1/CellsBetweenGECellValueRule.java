package ar.fiuba.tdd.template.tp1;

import java.util.List;

class CellsBetweenGECellValueRule extends Rule {

    @Override
    public boolean isValidBoard(Board board) {
        List<Sector> sectors = board.getColumnsSectors();
        sectors.addAll(board.getRowsSectors());

        for (Sector sector : sectors) {
            if (!isValidSector(sector)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isValidSector(Sector sector) {
        List<BoardElement> elements = sector.getBoardElements();

        for (BoardElement oneElement : elements) {
            Cell oneCell = (Cell) oneElement;
            if (!oneCell.hasValue()) {
                continue;
            }
            for (BoardElement otherElement : elements) {
                int oneValue = oneCell.getValue();
                int otherValue = ((Cell) otherElement).getValue();
                if (elementsTooClose(oneElement, otherElement, oneValue, otherValue)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean elementsTooClose(BoardElement oneElement, BoardElement otherElement,
                                    int oneValue, int otherValue) {
        if (!oneElement.equals(otherElement) && oneValue == otherValue) {
            int cellsBetween = getCellsBetweenPositions(oneElement.getPosition(), otherElement.getPosition());
            if (cellsBetween < oneValue) {
                return false;
            }
        }
        return true;
    }

    private int getCellsBetweenPositions(Position firstPosition, Position anotherPosition) {
        int firstX = firstPosition.getXcoordinate();
        int anotherX = anotherPosition.getXcoordinate();

        int firstY = firstPosition.getYcoordinate();
        int anotherY = anotherPosition.getYcoordinate();

        int maxCoordinate = firstX != anotherX ? Integer.max(firstX, anotherX) : Integer.max(firstY, anotherY);
        int minCoordinate = firstX != anotherX ? Integer.min(firstX, anotherX) : Integer.min(firstY, anotherY);

        return maxCoordinate - minCoordinate + 1;
    }
}
