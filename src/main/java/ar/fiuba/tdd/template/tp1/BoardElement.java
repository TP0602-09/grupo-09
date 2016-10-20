package ar.fiuba.tdd.template.tp1;

public abstract class BoardElement {

    protected Position position;

    public BoardElement() {}

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    @SuppressWarnings("CPD-START")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        BoardElement that = (BoardElement) obj;

        return position.equals(that.position);
    }
    @SuppressWarnings("CPD-END")

    @Override
    public int hashCode() {
        return position.hashCode();
    }

    public Position getPosition() {
        return position;
    }
}
