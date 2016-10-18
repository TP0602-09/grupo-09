package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Lucía on 16/10/2016.
 */
public abstract class Rule {

    public boolean areSectorsValid(Board board) {
        List<Sector> sectors = board.getSectors();
        for (Sector aSector : sectors) {
            if (!validSectorEspecificRule(aSector))
                return false;
        }
        return true;
    }

    public abstract boolean validSectorEspecificRule(Sector sector);
}
