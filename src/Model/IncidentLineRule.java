package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


public class IncidentLineRule extends Rule {
    private static final int LEFT_SLASH = 1;
    private static final int RIGHT_SLASH = 2;
    private HashMap<Position, CornerValues> corners;

    private static IncidentLineRule ourInstance = null;

    public static IncidentLineRule getInstance(
            HashMap<Position, CornerValues> cornerValues) {
        if (ourInstance == null) {
            ourInstance = new IncidentLineRule(cornerValues);
        } else {
            ourInstance.setCorners(cornerValues);
        }
        return ourInstance;
    }

    public static IncidentLineRule getInstance() {
        if (ourInstance == null) {
            throw new NullPointerException(
                    "IncidentLineRule instance is null");
        }
        return ourInstance;
    }

    private IncidentLineRule(HashMap<Position, CornerValues> corners) {
        this.corners = corners;
    }

    @Override
    public boolean isValid(List<Cell> cells) {
        Cell cell = cells.get(0);
        cells.remove(cell);
        Position position = getCellPosition(cell.getPosition());
        if (position == null) {
            return false;
        }
        ArrayList<Cell> upperLeftCells = getUpperLeftCells(cells, cell);
        ArrayList<Cell> uppertRightCells = getUpperRightCells(cells, cell);
        ArrayList<Cell> downLeftCells = getDownLeftCells(cells, cell);
        ArrayList<Cell> downRightCells = getDownRightCells(cells, cell);
        return validateCorners(upperLeftCells, uppertRightCells,
                downLeftCells, downRightCells, cell.getValue(),
                position);
    }

    private Position getCellPosition(Position position) {
        Iterator<Position> iterator = corners.keySet().iterator();
        for (Position next : corners.keySet()) {
            if (next.getX() == position.getX() && next.getY() ==
                    position.getY()) {
                return next;
            }
        }
        return null;
    }

    private boolean validateCorners(ArrayList<Cell> upperLeftCells,
                                    ArrayList<Cell> uppertRightCells,
                                    ArrayList<Cell> downLeftCells,
                                    ArrayList<Cell> downRightCells,
                                    int value,
                                    Position position) {
        return validateUpperLeftCorner(upperLeftCells, position, value) &&
                validateUpperRightCorner(uppertRightCells, position, value) &&
                validateDownLeftCorner(downLeftCells, position, value) &&
                validateDownRightCorner(downRightCells, position, value);
    }

    private boolean validateDownRightCorner(ArrayList<Cell> downRightCells,
                                            Position position, int value) {
        int incidentCount = actualIncidentLinesDownRight(downRightCells, position, value);
        return incidentCount <= (corners.get(position) != null ?
                corners.get(position).getDownRight() : 0);
    }

    private boolean validateDownLeftCorner(ArrayList<Cell> downLeftCells,
                                           Position position, int value) {
        int incidentCount = actualIncidentLinesDownLeft(downLeftCells, position, value);
        return incidentCount <= (corners.get(position) != null ?
                corners.get(position).getDowmLeft() : 0);
    }

    private boolean validateUpperRightCorner(ArrayList<Cell>
                                                     uppertRightCells,
                                             Position position, int value) {
        int incidentCount = actualIncidentLinesUpperRight(uppertRightCells, position, value);
        return incidentCount <= (corners.get(position) != null ?
                corners.get(position).getUpperRight() : 0);
    }

    private boolean validateUpperLeftCorner(ArrayList<Cell> upperLeftCells,
                                            Position position, int value) {
        int incidentCount = actualIncidentLinesUpperLeft(upperLeftCells, position, value);
        return incidentCount <= (corners.get(position) != null ?
                corners.get(position).getUpperLeft() : 0);


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
                if (cell.getValue() == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue() == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue() == RIGHT_SLASH) {
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
                if (cell.getValue() == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() - 1) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue() == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX()) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue() == LEFT_SLASH) {
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
                if (cell.getValue() == LEFT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY() - 1)) {
                if (cell.getValue() == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue() == LEFT_SLASH) {
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
                if (cell.getValue() == RIGHT_SLASH) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY())) {
                if (cell.getValue() == RIGHT_SLASH) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1) &&
                    (cell.getPosition().getY() == position.getY() + 1)) {
                if (cell.getValue() == LEFT_SLASH) {
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

    private void setCorners(HashMap<Position, CornerValues> corners) {
        this.corners = corners;
    }
}
