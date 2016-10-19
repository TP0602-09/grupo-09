package ar.fiuba.tdd.template.tp1;
@SuppressWarnings("Default File template")

public class Position {

    private int xcoordinate;
    private int ycoordinate;

    public Position(int xcoordinate,int ycoordinate) {
        this.xcoordinate = xcoordinate;
        this.ycoordinate = ycoordinate;
    }

    public int getXcoordinate() {
        return this.xcoordinate;
    }

    public int getYcoordinate() {
        return this.ycoordinate;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Position position = (Position) object;

        return xcoordinate == position.getXcoordinate() && ycoordinate == position.getYcoordinate();

    }

    @Override
    public int hashCode() {
        int result = xcoordinate;
        result = 31 * result + ycoordinate;
        return result;
    }

}
