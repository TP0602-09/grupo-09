package ar.fiuba.tdd.template.tp1;

import java.util.Set;

public abstract class JoinRule extends Rule {
    protected Set<Join> joins;

    @Override
    public boolean isValidBoard(Board board) {
        this.joins = board.getJoins();
        return super.isValidBoard(board);
    }
}
