package Model;

import java.util.List;


public class NotClosedPathRule extends Rule {
    @Override
    public boolean isValid(List<Cell> cells) {
        if (cells.size() > 3) return false;
        Cell candidate = cells.get(0);
        Cell firstInPath = cells.get(1);
        Cell lastInPath = cells.get(cells.size() - 1);
        if (!adjacents(candidate.getPosition(),
                firstInPath.getPosition(),
                lastInPath.getPosition())) {
            return false;
        }
        boolean valid = validateAllRightSlashes(candidate,
                firstInPath,
                lastInPath);
        if (valid) return true;
        valid = validateAllLeftSlashes(candidate, firstInPath, lastInPath);
        if (valid) return true;
        valid = validateRightLeftLeft(candidate, firstInPath, lastInPath);
        if (valid) return true;
        valid = validateRightLeftLeft(candidate, lastInPath, firstInPath);
        if (valid) return true;
        valid = validateRightLeftRight(candidate, firstInPath, lastInPath);
        return valid || validateLeftRightLeft(candidate, firstInPath, lastInPath);
    }

    private boolean validateLeftRightLeft(Cell candidate, Cell firstInPath, Cell lastInPath) {
        return firstInPath.getValue() != lastInPath.getValue() && validateLeftRightLeftPositions(candidate, firstInPath, lastInPath);
    }

    private boolean validateLeftRightLeftPositions(Cell candidate, Cell firstInPath, Cell lastInPath) {
        Cell first = firstInPath.getValue() == 2 ? firstInPath : lastInPath;
        Cell last = firstInPath.getValue() == 1 ? lastInPath : firstInPath;
        boolean valid = validateRLR1(candidate, firstInPath, lastInPath);
        if (valid) return true;
        valid = validateLRL2(candidate, first, last);
        if (valid) return true;
        valid = validateLRL3(candidate, first, last);
        return valid || validateLRL4(candidate, first, last);
    }

    private boolean validateRightLeftRight(Cell candidate, Cell firstInPath, Cell lastInPath) {
        return firstInPath.getValue() != lastInPath.getValue() && validateRightLeftRightPositions(candidate, firstInPath, lastInPath);
    }

    private boolean validateRightLeftRightPositions(Cell candidate, Cell firstInPath, Cell lastInPath) {
        Cell first = firstInPath.getValue() == 1 ? firstInPath : lastInPath;
        Cell last = firstInPath.getValue() == 2 ? lastInPath : firstInPath;
        boolean valid = validateRLR1(candidate, firstInPath, lastInPath);
        if (valid) return true;
        valid = validateRLR2(candidate, first, last);
        if (valid) return true;
        valid = validateRLR3(candidate, first, last);
        return valid || validateRLR4(candidate, first, last);
    }

    private boolean validateRLR1(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() - 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() - 1);
    }


    private boolean validateRLR2(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() - 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() + 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY());
    }

    private boolean validateRLR3(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() + 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() - 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() - 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY());
    }

    private boolean validateRLR4(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() + 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() - 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1);
    }


    private boolean validateLRL1(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() - 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY()) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() + 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1);
    }


    private boolean validateLRL2(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX()) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() - 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() - 1);
    }

    private boolean validateLRL3(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX()) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY() - 1) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() + 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1);
    }

    private boolean validateLRL4(Cell candidate, Cell firstInPath,
                                 Cell lastInPath) {
        return (firstInPath.getPosition().getX() ==
                candidate.getPosition().getX() - 1) &&
                (firstInPath.getPosition().getY() ==
                        candidate.getPosition().getY()) &&
                lastInPath.getPosition().getX() ==
                        candidate.getPosition().getX() + 1 &&
                (lastInPath.getPosition().getY() ==
                        candidate.getPosition().getY() + 1);
    }


    private boolean validateRightLeftLeft(Cell candidate, Cell firstInPath, Cell lastInPath) {
        return !(candidate.getValue() != 2 || firstInPath.getValue() != 1 || lastInPath.getValue() != 1) && validateRightLeftLeftPositions(candidate.getPosition(), firstInPath.getPosition(), lastInPath.getPosition());
    }

    private boolean validateRightLeftLeftPositions(Position position, Position position1, Position position2) {
        boolean valid = validateRLLPos(position, position1, position2);
        return valid && validateRLLPos(position, position2, position1);
    }

    private boolean validateRLLPos(Position position, Position position1, Position position2) {
        return (position1.getX() == position.getX() - 1 &&
                position1.getY() == position.getY() &&
                position2.getX() == position.getX() &&
                position2.getY() == position.getY() - 1) ||
                (position1.getX() == position.getX() - 1 &&
                        position1.getY() == position.getY() &&
                        position2.getX() == position.getX() &&
                        position2.getY() == position.getY() - 1
                );
    }


    private boolean validateAllLeftSlashes(Cell candidate, Cell firstInPath, Cell lastInPath) {
        return !(candidate.getValue() != 1 || firstInPath.getValue() != 1 || lastInPath.getValue() != 1) && validateAllLeftSlashesPositions(candidate.getPosition(), firstInPath.getPosition(), lastInPath.getPosition());
    }

    private boolean validateAllLeftSlashesPositions(Position position, Position position1, Position position2) {
        return ((position1.getX() == position.getX() - 1 &&
                position1.getY() == position.getY() + 1) &&
                (position2.getX() == position.getX() + 1) &&
                (position2.getY() == position.getY() - 1)
        ) ||
                ((position2.getX() == position.getX() - 1 &&
                        position2.getY() == position.getY() + 1) &&
                        (position1.getX() == position.getX() + 1) &&
                        (position1.getY() == position.getY() - 1));

    }

    private boolean validateAllRightSlashes(Cell candidate, Cell firstInPath, Cell lastInPath) {
        return !(candidate.getValue() != 2 || firstInPath.getValue() != 2 || lastInPath.getValue() != 2) && validateAllRightSlashesPositions(candidate.getPosition(), firstInPath.getPosition(), lastInPath.getPosition());
    }

    private boolean validateAllRightSlashesPositions(Position position, Position position1, Position position2) {
        return ((position1.getX() == position.getX() - 1 &&
                position1.getY() == position.getY() - 1) &&
                (position2.getX() == position.getX() + 1) &&
                (position2.getY() == position.getY() + 1)
        ) || ((position2.getX() == position.getX() + 1 &&
                position2.getY() == position.getY() + 1) &&
                (position1.getX() == position.getX() - 1) &&
                (position1.getY() == position.getY() - 1));
    }


    private boolean adjacents(Position position, Position position1, Position position2) {
        return (((max(position.getX(), position1.getX()) -
                min(position.getX(), position1.getY()) == 1) ||
                (max(position.getY(), position1.getY())) -
                        min(position.getY(), position1.getY()) == 1)) &&
                (((max(position.getX(), position2.getX()) -
                        min(position.getX(), position2.getX()) == 1) ||
                        (max(position.getY(), position2.getY())) -
                                min(position.getY(), position2.getY()) == 1));
    }

    private int min(int x, int y) {
        if (x <= y) {
            return x;
        }
        return y;
    }

    private int max(int x, int y) {
        if (y <= x) {
            return x;
        }
        return y;
    }
}
