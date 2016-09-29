package Control;

import Model.Cell;
import Model.DataCell;
import Model.Game;
import Model.Position;
import Model.EditableCell;
import View.CellView;
import View.DataCellView;
import View.EditableCellView;

import javax.swing.*;
import java.awt.*;

import java.util.*;
import java.util.List;


public class ViewController implements Observer {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private Game game;
    private JPanel mainPane;
    private HashMap<Integer, CellView> cells;
    private JFrame frame;

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
                //TODO: CREAR FACTORY KAKURO
            } else {
                cellView = new EditableCellView(posX, posY);
                EditableCellView cellReference = (EditableCellView) cellView;
                cellReference.observableCell.addObserver(this);

            }
            this.addCellToMainPane(cellView);
            this.cells.put(count, cellView);
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
        this.frame = new JFrame("ViewController");
        //  frame.setLayout(new BorderLayout());
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setContentPane(this.mainPane);
        //Display the window.
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public void update(Observable o, Object arg) {
        List<Object> message = (ArrayList<Object>) arg;
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
            System.out.println("Adelante! Este numero es valido");
        } else {
            System.out.println("Lo sentimos, este valor es invalido, pruebe ingresando otro valor");
        }
    }

    public void imprimirPosisicion(Position pos) {
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

    }

    public void setGame(Game game) {
        this.game = game;
    }
}