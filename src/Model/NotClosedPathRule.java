package Model;

import java.util.ArrayList;
import java.util.List;


public class NotClosedPathRule extends Rule {
    private Graph path;

    private static NotClosedPathRule ourInstance;

    public static NotClosedPathRule getInstance() {
        if (ourInstance == null) {
            ourInstance = new NotClosedPathRule();
        }
        return ourInstance;
    }


    private NotClosedPathRule() {
        path = null;
    }

    public void setPath(Graph path) {
        this.path = path;
    }

    @Override
    public boolean isValid(List<Cell> cells) {
        if (cells.size() > 0) {
            return false;
        }
        return path.isCyclic();
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
