package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class IncidentLineRule extends Rule {
    private static final int LEFT_SLASH = 1;
    private static final int RIGHT_SLASH = 2;
    private HashMap<Position, CornerValues> corners;


    public IncidentLineRule(HashMap<Position,CornerValues> corners) {
        this.corners = corners;
    }

    @Override
    public boolean isValid(List<Cell> cells) {

        Cell cell = cells.get(0);
        cells.remove(cell);
        ArrayList<Cell> upperLeftCells = getUpperLeftCells(cells,cell);
        ArrayList<Cell> uppertRightCells = getUpperRightCells(cells,cell);
        ArrayList<Cell> downLeftCells = getDownLeftCells(cells,cell);
        ArrayList<Cell> downRightCells = getDownRightCells(cells,cell);
        return validateCorners(upperLeftCells, uppertRightCells,
                downLeftCells, downRightCells,cell,cell.getPosition());


    }

    private boolean validateCorners(ArrayList<Cell> upperLeftCells,
                                    ArrayList<Cell> uppertRightCells,
                                    ArrayList<Cell> downLeftCells,
                                    ArrayList<Cell> downRightCells,
                                    Cell cell,
                                    Position position) {
        return validateUpperLeftCorner(upperLeftCells,position,cell.getValue()) &&
            validateUpperRightCOrner(uppertRightCells, position, cell.getValue()) &&
            validateDownLeftCorner(downLeftCells, position, cell.getValue())&&
            validateDownRightCorner(downRightCells, position,cell.getValue());
    }

    private boolean validateDownRightCorner(ArrayList<Cell> downRightCells,
                                            Position position, int value) {
        int incidentCount = actualIncidentLinesDownRight(downRightCells, position, value);
        return incidentCount <= (corners.get(position) == null?
                corners.get(position).getDownRight() : 0);
    }

    private boolean validateDownLeftCorner(ArrayList<Cell> downLeftCells,
                                           Position position, int value) {
        int incidentCount = actualIncidentLinesDownLeft(downLeftCells, position, value);
        return incidentCount <= (corners.get(position) == null?
                corners.get(position).getDowmLeft() : 0);
    }

    private boolean validateUpperRightCOrner(ArrayList<Cell>
                                                     uppertRightCells,
                           Position position, int value) {
        int incidentCount = actualIncidentLinesUpperRight(uppertRightCells, position, value);
        return incidentCount <= (corners.get(position) == null?
                corners.get(position).getUpperRight() : 0);
    }

    private boolean validateUpperLeftCorner(ArrayList<Cell> upperLeftCells,
                                            Position position, int value) {
        int incidentCount = actualIncidentLinesUpperLeft(upperLeftCells, position, value);
        return incidentCount <= (corners.get(position) == null?
                corners.get(position).getUpperLeft() : 0);


    }

    private int actualIncidentLinesUpperLeft(ArrayList<Cell> cells,
                                    Position position,
                                    int value) {
       if (value == RIGHT_SLASH) {return 0;}
        int count = 1;
        for (Cell cell:cells) {
                if ((cell.getPosition().getX() == position.getX() - 1)&&
                        (cell.getPosition().getY() == position.getY() -1)){
                    if (cell.getValue() == LEFT_SLASH ) {
                        count++;
                    }
                }

            if ((cell.getPosition().getX() == position.getX() + 1)&&
                    (cell.getPosition().getY() == position.getY() -1)){
                if (cell.getValue() == RIGHT_SLASH ) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() - 1)&&
                    (cell.getPosition().getY() == position.getY())){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }
        }
        return count;
    }



    private int actualIncidentLinesUpperRight(ArrayList<Cell> cells,
                                             Position position,
                                             int value) {
        if (value == LEFT_SLASH) {return 0;}
        int count = 1;
        for (Cell cell:cells) {
            if ((cell.getPosition().getX() == position.getX() - 1)&&
                    (cell.getPosition().getY() == position.getY())){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() - 1)&&
                    (cell.getPosition().getY() == position.getY() + 1)){
                if (cell.getValue() == RIGHT_SLASH ) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX())&&
                    (cell.getPosition().getY() == position.getY() + 1)){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }
        }
        return count;
    }



    private int actualIncidentLinesDownLeft(ArrayList<Cell> cells,
                                              Position position,
                                              int value) {
        if (value == LEFT_SLASH) {return 0;}
        int count = 1;
        for (Cell cell:cells) {
            if ((cell.getPosition().getX() == position.getX())&&
                    (cell.getPosition().getY() == position.getY()-1)){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1)&&
                    (cell.getPosition().getY() == position.getY() - 1)){
                if (cell.getValue() == RIGHT_SLASH ) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1)&&
                    (cell.getPosition().getY() == position.getY())){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }
        }
        return count;
    }

    private int actualIncidentLinesDownRight(ArrayList<Cell> cells,
                                              Position position,
                                              int value) {
        if (value == RIGHT_SLASH) {return 0;}
        int count = 1;
        for (Cell cell:cells) {
            if ((cell.getPosition().getX() == position.getX() )&&
                    (cell.getPosition().getY() == position.getY() + 1)){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }

            if ((cell.getPosition().getX() == position.getX() + 1)&&
                    (cell.getPosition().getY() == position.getY())){
                if (cell.getValue() == RIGHT_SLASH ) {
                    count++;
                }
            }
            if ((cell.getPosition().getX() == position.getX() + 1)&&
                    (cell.getPosition().getY() == position.getY() + 1)){
                if (cell.getValue() == LEFT_SLASH ) {
                    count++;
                }
            }
        }
        return count;
    }

    private ArrayList<Cell> getUpperLeftCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent: cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() - 1)||
                    adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY())
            {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getDownRightCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent: cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() + 1) ||
                    (adjacent.getPosition().getX()  == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY())||
                    adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY()+  1 )
            {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getUpperRightCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent: cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() - 1 &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() ) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() -1  &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() + 1 - 1)||
                    adjacent.getPosition().getX() == cell.getPosition().getX() &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() + 1)
            {
                array.add(adjacent);
            }
        }
        return array;
    }

    private ArrayList<Cell> getDownLeftCells(List<Cell> cells, Cell cell) {
        ArrayList<Cell> array = new ArrayList<>();
        for (Cell adjacent: cells) {
            if ((adjacent.getPosition().getX() == cell.getPosition().getX() &&
                    adjacent.getPosition().getY() == cell.getPosition().getY() - 1) ||
                    (adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY() - 1)||
                    adjacent.getPosition().getX() == cell.getPosition().getX() + 1 &&
                            adjacent.getPosition().getY() == cell.getPosition().getY())
            {
                array.add(adjacent);
            }
        }
        return array;
    }
}
