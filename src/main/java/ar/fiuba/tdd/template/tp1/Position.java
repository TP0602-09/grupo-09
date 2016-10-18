package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 16/10/2016.
 */
public class Position {

    private int x;
    private int y;

    public Position(int x,int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        return x == position.getX() && y == position.getY();

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
