package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class SudokuSectorBuilderStrategy extends SectorBuilderStrategy {
    @Override
    public List<List<Cell>> getSectorsToValidate(Cell cell, HashMap<Position,Cell> cells) {
        List<List<Cell>> sectors = new ArrayList<>();

        sectors.add(getRow(cell,cells));
        sectors.add(getColumn(cell,cells));
        sectors.add(getMatrix(cell,cells));

        return sectors;
    }

    private List<Cell> getColumn(Cell cell,HashMap<Position,Cell> cells) {
        List<Cell> columnCells = new ArrayList<>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        cells.keySet().stream().filter(pos -> pos.getX() == posX).
                forEach(pos -> {
            if (pos.getY() == posY) {
                columnCells.add(cell);
            } else {
                columnCells.add(cells.get(pos));
            }
        });
        return columnCells;
    }

    private List<Cell> getRow(Cell cell,HashMap<Position,Cell> cells) {
        List<Cell> rowCells = new ArrayList<>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        cells.keySet().stream().filter(pos -> pos.getY() == posY).
                forEach(pos -> {
            if (pos.getX() == posX) {
                rowCells.add(cell);
            } else {
                rowCells.add(cells.get(pos));
            }
        });
        return rowCells;
    }

    private List<Cell> getMatrix(Cell cell,HashMap<Position,Cell> cells) {
        List<Cell> matrixCells = new ArrayList<>();

        int posX = cell.getPosition().getX();
        int posY = cell.getPosition().getY();

        int modX = posX % 3;
        int modY = posY % 3;

        int posIniX = posX - modX;
        int posIniY = posY - modY;

        for (int x = posIniX; x < posIniX + 3; x++) {
            for (int y = posIniY; y < posIniY + 3; y++) {
                Position pos = new Position(x + 1, y + 1);
                if (pos.equals(cell.getPosition())) {
                    matrixCells.add(cell);
                } else {
                    matrixCells.add(cells.get(pos));
                }
            }
        }
        return matrixCells;
    }

}
