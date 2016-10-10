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
        return path.isCyclic();
    }
}
