package Control;
import View.CellView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;



public class ViewController {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private JPanel mainPane;
    private ArrayList cells;

    public ViewController (int numberOfRows){
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

    public  void setCells(ArrayList cells){
        this.cells = cells;
        // Use iterator to display contents of al
        Iterator itr = cells.iterator();

        while(itr.hasNext()) {
            Object cell = itr.next();
            this.addCellToMainPane((CellView)cell);
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