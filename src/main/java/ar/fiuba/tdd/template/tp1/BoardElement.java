package ar.fiuba.tdd.template.tp1;

public abstract class BoardElement {

    protected Position position;

    public BoardElement(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardElement that = (BoardElement) o;

        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }

    public Position getPosition() {
        return position;
    }
}
