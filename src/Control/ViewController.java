package Control;
import Model.Cell;
import Model.DataCell;
import View.CellView;
import View.DataCellView;
import View.EditableCellView;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;



public class ViewController {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private JPanel mainPane;
    private HashMap<Integer,CellView> cells;

    public ViewController (int numberOfRows){
        this.cells = new HashMap<Integer, CellView>();
        createMainPain(numberOfRows);
    }

    private void createMainPain(int numberOfRows){
        //creo el mainPane
        mainPane = new JPanel();
        mainPane.setLayout(new GridLayout(0,numberOfRows));
        mainPane.setOpaque(true);
        mainPane.setBackground(new Color(255, 0, 0));
        mainPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
    }

    public  void setCells(HashMap<Integer, Cell> cells){
        factoryCellsCreator(cells);
    }

    public void factoryCellsCreator(HashMap<Integer, Cell> cells){
        Integer count = 1;
        while(count <= cells.size()) {
            Cell cellObj = cells.get(count);
            CellView cellView;
            int posX = cellObj.getPosition().getX();
            int posY = cellObj.getPosition().getY();
            if (cellObj instanceof DataCell){
                cellView =  new DataCellView(posX,posY,cellObj.getValue());
            }else{
                cellView = new EditableCellView(posX,posY);
            }
            this.addCellToMainPane(cellView);
            this.cells.put(count,cellView);
            count++;
        }
    }

    public void addElementToMainPane(Container viewToDraw){
        this.mainPane.add(viewToDraw);
    }

    public void addCellToMainPane(CellView cellView){
        this.mainPane.add(cellView);

    }
    public void render(){
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(this.mainPane);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}