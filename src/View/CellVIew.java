/**
 * Created by mariagustina on 24/09/16.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellVIew extends JPanel implements ActionListener {

    //Fields for data entry
    private JFormattedTextField cell;
    public int x; //posicion (1,1) ; (1,2) ; (2,1)..etc
    public int y;

    public CellVIew(int x,int y) {

        super(new BorderLayout());
        this.x=x;
        this.y=y;
        // setUpFormats();

        //Create the text field and set it up.
        cell = new JFormattedTextField();
//        amountField.setValue(new Double(amount));
        cell.setPreferredSize( new Dimension( 20, 20 ) );
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setEnabled(true);
        //cell.addPropertyChangeListener("value", this);
        cell.addActionListener(this);
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


    public void actionPerformed(ActionEvent e) {
        String numero = e.getActionCommand();
        Object s = e.getSource();

        System.out.println("Se recibio el numero: ");
        System.out.println(numero);
        System.out.println("source");
        System.out.println(s);
    }
}