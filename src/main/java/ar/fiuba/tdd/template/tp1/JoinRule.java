package ar.fiuba.tdd.template.tp1;

import java.util.List;

/**
 * Created by Agata on 20/10/2016.
 */
public abstract class JoinRule extends Rule {
    protected List<Join> joins;

    @Override
    public boolean isValidBoard(Board board) {
        this.joins = board.getJoins();
        return super.isValidBoard(board);
    }
}
