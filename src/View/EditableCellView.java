/**
 * Created by mariagustina on 24/09/16.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableCellView extends CellView implements ActionListener {

    //Fields for data entry
    private JFormattedTextField cell;

    public EditableCellView(int x, int y) {

        super(x,y);

        //Create the text field and set it up.
        cell = new JFormattedTextField();
        cell.setPreferredSize( new Dimension( 20, 20 ) );
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setEnabled(true);
        cell.addActionListener(this);
        cell.setBackground(new Color(239, 255, 165));

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.setBackground(Color.blue);
        fieldPane.add(cell);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );
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