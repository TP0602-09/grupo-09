/**
 * Created by mariagustina on 24/09/16.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CellVIew extends JPanel implements PropertyChangeListener {

    //Fields for data entry
    private JFormattedTextField cell;

    public  CellVIew() {

        super(new BorderLayout());
       // setUpFormats();

        //Create the text field and set it up.
        cell = new JFormattedTextField();
//        amountField.setValue(new Double(amount));
        cell.setPreferredSize( new Dimension( 20, 20 ) );
     // cell.setColumns(2);
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setEnabled(true);
        cell.addPropertyChangeListener("value", this);
        cell.setBackground(new Color(239, 255, 165));

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.setBackground(Color.blue);
        fieldPane.add(cell);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );
        //Put the panels in this panel, labels on left,
        //text fields on right.
        //setBorder(BorderFactory.createLineBorder(Color.black));
        add(fieldPane);
    }

    /** Called when a field's "value" property changes. */
    public void propertyChange(PropertyChangeEvent e) {
        Object source = e.getSource();
        if (source == cell) {
            //cell = ((Number)cell.getValue()).doubleValue();
        }

        //double payment = computePayment(amount, rate, numPeriods);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
   /* private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FormattedTextFieldDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add contents to the window.
        frame.add(new CellVIew());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    */
    public void render(JFrame frame){
        //Add contents to the window.
        frame.add(new CellVIew());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

   /* public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }*/

    //Compute the monthly payment based on the loan amount,
    //APR, and length of loan.
   /* double computePayment(double loanAmt, double rate, int numPeriods) {
        double I, partial1, denominator, answer;

        numPeriods *= 12;        //get number of months
        if (rate > 0.01) {
            I = rate / 100.0 / 12.0;         //get monthly rate from annual
            partial1 = Math.pow((1 + I), (0.0 - numPeriods));
            denominator = (1 - partial1) / I;
        } else { //rate ~= 0
            denominator = numPeriods;
        }

        answer = (-1 * loanAmt) / denominator;
        return answer;
    }*/

    //Create and set up number formats. These objects also
    //parse numbers input by user.
    /*private void setUpFormats() {
        amountFormat = NumberFormat.getNumberInstance();

        percentFormat = NumberFormat.getNumberInstance();
        percentFormat.setMinimumFractionDigits(3);

        paymentFormat = NumberFormat.getCurrencyInstance();
    }*/
}