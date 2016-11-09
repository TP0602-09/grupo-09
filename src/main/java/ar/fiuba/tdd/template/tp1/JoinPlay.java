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
        System.out.print("You are going to join position (" + firstPosition.getXcoordinate()
                + "," + firstPosition.getYcoordinate() + ") ");
        System.out.println("whit position (" + secondPosition.getXcoordinate() + ","
                + secondPosition.getYcoordinate() + ")");
        board.addJoin(join);
        board.getMadePlays().push(this);
    }

    @Override
    public void rollback(Board board) {
        board.deleteJoin(join);
    }
}
