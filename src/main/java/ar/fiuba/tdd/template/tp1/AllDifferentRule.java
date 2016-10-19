package ar.fiuba.tdd.template.tp1;


import java.util.ArrayList;

/**
 * Created by Lucía on 17/10/2016.
 */
public class AllDifferentRule extends Rule {

    @Override
    public boolean validSectorSpecificRule(Sector sector) {
        //TODO implement method (chequear que todos los numeros sean diferentes)
        ArrayList<Integer> values = this.extractCellValues(sector);
        return false;
    }
}
