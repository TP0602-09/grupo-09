package ar.fiuba.tdd.template.tp1;

public abstract class Play {
    private boolean valid;

    public Play() {
        this.valid = true;
    }

    public abstract void doIt(Board board);

    public abstract void rollback(Board board);

    public void setInvalid() {
        this.valid = false;
    }

    public boolean isValid() {
        return valid;
    }
}
