package Model;

import java.util.List;


public class NotClosedPathRule  extends Rule{
    @Override
    public boolean isValid(List<Cell> cells) {

        return false;
    }
}
