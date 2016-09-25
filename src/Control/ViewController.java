package Control;
import javax.swing.*;
import java.awt.*;

public class ViewController {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private JPanel mainPane;

    public ViewController (){

        //creo el mainPane
        mainPane = new JPanel();
        mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
        mainPane.setOpaque(true);
        mainPane.setBackground(new Color(255, 0, 0));
        mainPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
//        mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
 //       mainPane.add(Box.createRigidArea(new Dimension(0, 5)));
  //      mainPane.add(Box.createGlue());

    }

    public void addElementToMainPane(Container viewToDraw){
        this.mainPane.add(viewToDraw);
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
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setContentPane(this.mainPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}