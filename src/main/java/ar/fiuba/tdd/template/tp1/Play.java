package ar.fiuba.tdd.template.tp1;

/**
 * Created by Lucía on 17/10/2016.
 */
public abstract class Play {
    private boolean valid;

    public Play() {
        this.valid = true;
    }

    public abstract void doIt(Board board);

    public void isInvalid() {
        this.valid = false;
    }

    public boolean isValid() {
        return valid;
    }
}
