package Model;
import java.util.List;


public class GameCountryRoad extends Game {
    private CountryRoadPathGenerator countryRoadPathGenerator;
    public GameCountryRoad(List<Rule> rules) {
        super(rules);
        this.countryRoadPathGenerator = new CountryRoadPathGenerator();
    }

    @Override
    public SectorBuilderStrategy currentStrategy() {
        return new RoomSectorBuilderStrategy();
    }


    @Override
    public boolean isValid(Cell cell){
        Graph graph = countryRoadPathGenerator.generatePath(cell.getPosition(),
                getBoard());
        List<List<Cell>> listCells = getBoard().getSectorsToValidate(cell,this);
        if (graph.isCyclic()) {
            EmptyNeighbourCellsInSameRoom emptyNeighbourCellsInSameRoom =
                    new EmptyNeighbourCellsInSameRoom();
            RoomIsFilled roomIsFilled = new RoomIsFilled();
            for (List<Cell> cells:listCells) {
                if (!(emptyNeighbourCellsInSameRoom.isValid(cells)&&
                        roomIsFilled.isValid(cells))){
                    return false;
                }
            }
            return true;
        } else {
            LinesInRoomsNotExcedded rule = new LinesInRoomsNotExcedded();
            for (List<Cell> cells:listCells) {
                if (!rule.isValid(cells)){
                    return false;
                }
            }
            return true;
        }
    }

}
