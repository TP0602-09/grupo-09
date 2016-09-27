package Model;

import java.util.ArrayList;

/**
 * Created by Lucía on 27/9/2016.
 */
public class SectorLoader {
    private static SectorLoader ourInstance = new SectorLoader();

    public static SectorLoader getInstance() {
        return ourInstance;
    }

    private SectorLoader() {}

    public ArrayList<Sector> loadSectors() {
        return new ArrayList<Sector>();
    }
}
