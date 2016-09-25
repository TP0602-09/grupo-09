package Control;
import View.CellVIew;

import javax.swing.*;
public class Main {

    public static void sayHello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        sayHello();
        mainGraphics();
    }

    public static void mainGraphics(){
        ViewController vc = new ViewController(2);

        JLabel label = new JLabel("Hello World");
     //   vc.addElementToMainPane(label);

        CellVIew cell = new CellVIew(1,1);
        vc.addElementToMainPane(cell);

        CellVIew cell2 = new CellVIew(1,2);
        vc.addElementToMainPane(cell2);

        CellVIew cell3 = new CellVIew(2,1);
        vc.addElementToMainPane(cell3);

      CellVIew cell4 = new CellVIew(2,2);
        vc.addElementToMainPane(cell4);
/*
        CellVIew cell5 = new CellVIew(1,1);
        vc.addCellToMainPane(cell5);

        CellVIew cell6 = new CellVIew(1,2);
        vc.addCellToMainPane(cell6);

        CellVIew cell7 = new CellVIew(2,1);
        vc.addCellToMainPane(cell7);

        CellVIew cell8 = new CellVIew(2,2);
        vc.addCellToMainPane(cell8);

        CellVIew cell9 = new CellVIew(2,2);
        vc.addCellToMainPane(cell9);
*/
        vc.render();
    }
}