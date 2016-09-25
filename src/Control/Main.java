package Control;
import View.CellView;
import View.DataCellView;
import View.DoubleDataCellView;
import View.EditableCellView;

import java.util.ArrayList;

public class Main {

    public static void sayHello() {
        System.out.println("Welcome to Nikoli's Game Generator Engine");
    }

    public static void main(String[] args) {
        sayHello();
        //mainGraphics();
        mainGame();
    }

    public static void mainGame(){
        EngineController ec = new EngineController("SUDOKU");

    }

    public static void mainGraphics(){
        ViewController vc = new ViewController(5);

        //creo las celdas de mentira por ahora
        ArrayList cellsArray = new ArrayList<EditableCellView>();

        CellView cell = new EditableCellView(1,1);
        cellsArray.add(cell);
        CellView cell2 = new EditableCellView(1,2);
        cellsArray.add(cell2);
        CellView cell3 = new EditableCellView(1,3);
        cellsArray.add(cell3);
        CellView cell4 = new EditableCellView(1,4);
        cellsArray.add(cell4);
        CellView cell5 = new EditableCellView(2,1);
        cellsArray.add(cell5);
        CellView cell6 = new EditableCellView(2,2);
        cellsArray.add(cell6);
        CellView cell7 = new EditableCellView(2,3);
        cellsArray.add(cell7);
        CellView cell8 = new EditableCellView(2,4);
        cellsArray.add(cell8);
        CellView cell9 = new EditableCellView(3,1);
        cellsArray.add(cell9);
        CellView cell10 = new DataCellView(3,2,6);
        cellsArray.add(cell10);
        CellView cell11 = new DataCellView(3,3,0);
        cellsArray.add(cell11);
        CellView cell12 = new DoubleDataCellView(3,3,48,25);
        cellsArray.add(cell12);
        CellView cell13 = new DoubleDataCellView(3,3,0,25);
        cellsArray.add(cell13);
        CellView cell14 = new DoubleDataCellView(3,3,0,9);
        cellsArray.add(cell14);
        CellView cell15 = new DoubleDataCellView(3,3,48,0);
        cellsArray.add(cell15);
        CellView cell16 = new DoubleDataCellView(3,3,4,0);
        cellsArray.add(cell16);
        CellView cell17 = new DoubleDataCellView(3,3,3,6);
        cellsArray.add(cell17);

        vc.setCells(cellsArray);

        vc.render();
    }
}