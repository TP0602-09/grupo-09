package ar.fiuba.tdd.template.tp1;

public class Join {

    private BoardElement firstElement;
    private BoardElement secondElement;

    public Join(BoardElement firstElement, BoardElement secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Join join = (Join) obj;

        if (firstElement.equals(join.firstElement) && secondElement.equals(join.secondElement)) {
            return true;
        }
        if (firstElement.equals(join.secondElement) && secondElement.equals(join.firstElement)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = firstElement.hashCode();
        result = 31 * result + secondElement.hashCode();
        return result;
    }

    public boolean hasBoardElement(BoardElement element) {
        return (firstElement.equals(element) || secondElement.equals(element));
    }


}
