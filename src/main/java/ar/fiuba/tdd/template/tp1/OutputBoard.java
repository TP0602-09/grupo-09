package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;
import java.util.List;

public class OutputBoard {

    private boolean status;
    private List<Sector> sectors = new ArrayList<>();

    public OutputBoard() {}

    public boolean isStatus() {
        return status;
    }

    public List<Sector> getSectors() {
        return sectors;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSectors(List<Sector> sectors) {
        this.sectors = sectors;
    }
}
