package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class IncidentLineRule extends Rule {
    private static final int LEFT_SLASH = 1;
    private static final int RIGHT_SLASH = 2;

    @Override
    public boolean isValid(List<Cell> cells) {
        Cell cell = cells.get(0);
        cells.remove(cell);
        ArrayList<Cell> upperLeftCells = getUpperLeftCells(cells, cell);
        ArrayList<Cell> upperRightCells = getUpperRightCells(cells, cell);
        ArrayList<Cell> downLeftCells = getDownLeftCells(cells, cell);
        ArrayList<Cell> downRightCells = getDownRightCells(cells, cell);
        return validateCorners(upperLeftCells, upperRightCells,
                downLeftCells, downRightCells, cell,
                cell.getPosition());
    }

    private boolean validateCorners(ArrayList<Cell> upperLeftCells,
                                    ArrayList<Cell> upperRightCells,
                                    ArrayList<Cell> downLeftCells,
                                    ArrayList<Cell> downRightCells,
                                    Cell cell,
                                    Position position) {
        return validateUpperLeftCorner(upperLeftCells, position, cell) &&
                validateUpperRightCorner(upperRightCells, position, cell) &&
                validateDownLeftCorner(downLeftCells, position, cell) &&
                validateDownRightCorner(downRightCells, position, cell);
    }

    private boolean validateDownRightCorner(ArrayList<Cell> downRightCells,
                                            Position position, Cell cell) {
        int incidentCount = actualIncidentLinesDownRight(downRightCells, position,
                cell.getValue()[0]);
        return incidentCount <= cell.getValue()[4];
    }

    private boolean validateDownLeftCorner(ArrayList<Cell> downLeftCells,
                                           Position position, Cell cell) {
        int incidentCount = actualIncidentLinesDownLeft(downLeftCells, position,
                cell.getValue()[0]);
        return incidentCount <= cell.getValue()[3];
    }

    private boolean validateUpperRightCorner(ArrayList<Cell>
                                                     upperRightCells,
                                             Position position, Cell cell) {
        int incidentCount = actualIncidentLinesUpperRight(upperRightCells, position,
                cell.getValue()[0]);
        return incidentCount <= cell.getValue()[2];
    }

    private boolean validateUpperLeftCorner(ArrayList<Cell> upperLeftCells,
                                            Position position, Cell cell) {
        int incidentCount = actualIncidentLinesUpperLeft(upperLeftCells, position,
                cell.getValue()[0]);
        return incidentCount <= cell.getValue()[1];


    }

    private int actualIncidentLinesUpperLeft(ArrayList<Cell> cells,
                                             Position position,
                                             int value) {
        if (value == RIGHT_SLASH) {
            return 0;
        }
        int count = 1;
        for (Cell cell : cells) {
            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }
        }
        return count;
    }


    private int actualIncidentLinesUpperRight(ArrayList<Cell> cells,
                                              Position position,
                                              int value) {
        if (value == LEFT_SLASH) {
            return 0;
        }
        int count = 1;
        for (Cell cell : cells) {
            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }
        }
        return count;
    }


    private int actualIncidentLinesDownLeft(ArrayList<Cell> cells,
                                            Position position,
                                            int value) {
        if (value == LEFT_SLASH) {
            return 0;
        }
        int count = 1;
        for (Cell cell : cells) {
            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }
        }
        return count;
    }

    private int actualIncidentLinesDownRight(ArrayList<Cell> cells,
                                             Position position,
                                             int value) {
        if (value == RIGHT_SLASH) {
            return 0;
        }
        int count = 1;
        for (Cell cell : cells) {
            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue()[0] == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue()[0] == LEFT_SLASH) {
                    count++;
                }
            }
        }
        return count;
    }

    private ArrayList<Cell> getUpperLeftCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent : cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY()) {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getDownRightCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent : cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() + 1) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY()) ||
                    adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() + 1) {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getUpperRightCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent : cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                    adjacent.getPosition().getY() == cell.getPosition().getY()) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() + 1) ||
                    adjacent.getPosition().getX() == cell.getPosition().getX() &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() + 1) {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getDownLeftCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent : cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY()) {
                array.add(adjacent);
            }
        }
        return array;
    }
}
