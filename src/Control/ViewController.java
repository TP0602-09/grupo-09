package Control;
import javax.swing.*;
import java.awt.*;

public class ViewController {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private Container viewToDraw;

    public void renderView(Container viewToDraw){
        this.viewToDraw = viewToDraw;
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ViewController");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container principalContainer = frame.getContentPane();
        principalContainer.add(this.viewToDraw);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

}