package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

class TwoConsecutiveBlackCellRule extends Rule {

    @Override
    public boolean isValidBoard(Board board) {
        List<Sector> sectors = getSectorsToValidate(board);

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
        int sum = 0;

        for (BoardElement element : elements) {
            if (((Cell) element).hasValue()) {
                sum += 1;
            }
        }

        return sum < 3;
    }

    private List<Sector> getSectorsToValidate(Board board) {
        List<Sector> sectors = new ArrayList<>();

        for (int x = 1; x <= board.getCols(); x++) {
            for (int y = 1; y <= board.getRows(); y++) {
                List<BoardElement> elements = getConsecutiveCellsIfBlack(board, new Position(x,y));
                sectors.add(new Sector(elements));
            }
        }
        return sectors;
    }

    private List<BoardElement> getConsecutiveCellsIfBlack(Board board, Position position) {
        List<BoardElement> elements = new ArrayList<>();

        Cell cell = (Cell) board.getElement(position);
        elements.add(cell);

        if (cell.getValue() > 0) {
            BoardElement element = getUpElement(board, position);
            addElementIfNotNull(elements, element);

            element = getDownElement(board, position);
            addElementIfNotNull(elements, element);

            element = getRightElement(board, position);
            addElementIfNotNull(elements, element);

            element = getLeftElement(board, position);
            addElementIfNotNull(elements, element);
        }

        return elements;
    }

    private BoardElement getLeftElement(Board board, Position position) {
        return getElement(board, position.getXcoordinate() - 1, position.getYcoordinate());
    }

    private BoardElement getRightElement(Board board, Position position) {
        return getElement(board, position.getXcoordinate() + 1, position.getYcoordinate());
    }

    private BoardElement getDownElement(Board board, Position position) {
        return getElement(board, position.getXcoordinate(), position.getYcoordinate() + 1);
    }

    private BoardElement getUpElement(Board board, Position position) {
        return getElement(board, position.getXcoordinate(), position.getYcoordinate() - 1);
    }

    private BoardElement getElement(Board board, int coordinateX, int coordinateY) {
        Position thePosition = new Position(coordinateX, coordinateY);
        return board.getElement(thePosition);
    }

    private void addElementIfNotNull(List<BoardElement> elements, BoardElement element) {
        if (element != null) {
            elements.add(element);
        }
    }

}
