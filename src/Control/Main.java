package Control;
import View.CellVIew;

import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void sayHello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        sayHello();
        mainGraphics();
    }

    public static void mainGraphics(){
        ViewController vc = new ViewController(3);

        JLabel label = new JLabel("Sudoku");
     //   vc.addElementToMainPane(label);

        //creo las celdas de mentira por ahora
        ArrayList cellsArray = new ArrayList<CellVIew>();

        CellVIew cell = new CellVIew(1,1);
        cellsArray.add(cell);
        CellVIew cell2 = new CellVIew(1,2);
        cellsArray.add(cell2);
        CellVIew cell3 = new CellVIew(2,1);
        cellsArray.add(cell3);
        CellVIew cell4 = new CellVIew(2,2);
        cellsArray.add(cell4);
        CellVIew cell5 = new CellVIew(1,1);
        cellsArray.add(cell5);
        CellVIew cell6 = new CellVIew(1,2);
        cellsArray.add(cell6);
        CellVIew cell7 = new CellVIew(2,1);
        cellsArray.add(cell7);
        CellVIew cell8 = new CellVIew(2,2);
        cellsArray.add(cell8);
        CellVIew cell9 = new CellVIew(2,2);
        cellsArray.add(cell9);

        vc.setCells(cellsArray);

        vc.render();
    }
}