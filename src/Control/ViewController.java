package Control;

import Model.*;
import View.CellView;
import View.DataCellView;
import View.EditableCellView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


public class ViewController implements Observer {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private Game game;
    private JPanel mainPane;
    protected HashMap<Integer, CellView> cells;

    public ViewController(int numberOfRows) {
        this.cells = new HashMap<Integer, CellView>();
        createMainPain(numberOfRows);
    }

    private void createMainPain(int numberOfRows) {
        //creo el mainPane
        mainPane = new JPanel();
        mainPane.setLayout(new GridLayout(0, numberOfRows));
        mainPane.setOpaque(true);
        mainPane.setBackground(new Color(255, 0, 0));
        mainPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    public void setCells(HashMap<Integer, Cell> cells) {
        factoryCellsCreator(cells);
    }

    public void factoryCellsCreator(HashMap<Integer, Cell> cells) {
        Integer count = 1;
        while (count <= cells.size()) {
            Cell cellObj = cells.get(count);
            CellView cellView;
            int posX = cellObj.getPosition().getX();
            int posY = cellObj.getPosition().getY();
            if (cellObj instanceof DataCell) {
                cellView = new DataCellView(posX, posY, cellObj.getValue());
                this.cells.put(count, cellView);
                //TODO: CREAR FACTORY KAKURO
            } else {
                cellView = new EditableCellView(posX, posY);
                EditableCellView cellReference = (EditableCellView) cellView;
                cellReference.observableCell.addObserver(this);
                this.cells.put(count, cellReference);
            }
            this.addCellToMainPane(cellView);
           // this.cells.put(count, cellView);
            count++;
        }
    }

    public void addCellToMainPane(CellView cellView) {
        this.mainPane.add(cellView);

    }

    public void render() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ViewController");
        //  frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setContentPane(this.mainPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public void update(Observable o, Object arg) {
        @SuppressWarnings("unchecked")
        ArrayList<Object> message = (ArrayList<Object>) arg;
        Integer value = (Integer) message.get(0);
        Position pos = (Position) message.get(1);
        System.out.print("Valor : ");
        System.out.print(value);
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

        Cell recievedCell = new EditableCell(pos);
        recievedCell.setValue(value);
        if (this.game.isValid(recievedCell)) {
            this.game.addValidCell(recievedCell);
            System.out.println("Adelante! Este numero es valido");
        } else {
            //TODO: borrar el numero en las vistas
            System.out.println("Lo sentimos, este valor es invalido, pruebe ingresando otro valor");
        }
    }
/*
    public void imprimirPosisicion(Position pos) {
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

    }
*/
    public void setGame(Game game) {
        this.game = game;
    }
}