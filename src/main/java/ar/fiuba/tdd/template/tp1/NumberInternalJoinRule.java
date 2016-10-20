package ar.fiuba.tdd.template.tp1;

/**
 * Created by Agata on 19/10/2016.
 */
public class NumberInternalJoinRule extends Rule {



    @Override
    public boolean isValidBoard(Board board) {
        // Obtengo Joins
        super.isValidBoard(board);
        return false;
    }

    @Override
    public boolean isValidSector(Sector sector) {


        return false;
    }
}
