package ar.fiuba.tdd.template.tp1;

public class JoinPlay extends Play {

    private Position firstPosition;
    private Position secondPosition;
    private Join join;

    public JoinPlay() {
    }

    public void setFirstPosition(Position firstPosition) {
        this.firstPosition = firstPosition;
    }

    public void setSecondPosition(Position secondPosition) {
        this.secondPosition = secondPosition;
    }

    @Override
    public void doIt(Board board) {
        BoardElement firstElement = board.getElement(this.firstPosition);
        BoardElement secondElement = board.getElement(this.secondPosition);
        join = new Join(firstElement, secondElement);
        board.addJoin(join);
    }

    @Override
    public void rollback(Board board) {
        board.deleteJoin(join);
    }
}
