/**
 * Created by mariagustina on 24/09/16.
 *
 */
package View;

import Model.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditableCellView extends CellView implements ActionListener{

    //Fields for data entry
    private JTextField cell;
    public ObservableCell observableCell;

    public EditableCellView(int x, int y) {

        super(x,y);

        this.observableCell = new ObservableCell();
        //Create the text field and set it up.
        cell = new JFormattedTextField();
        cell.setPreferredSize( new Dimension( 20, 20 ) );
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setEnabled(true);
        cell.addActionListener(this);
        cell.setBackground(new Color(239, 255, 165));
       // cell.getDocument().addDocumentListener();

        //Layout the text fields in a panel.
        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.setBackground(Color.blue);
        fieldPane.add(cell);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );
        add(fieldPane);

    }


    public void actionPerformed(ActionEvent e) {
        Integer numero = Integer.parseInt(e.getActionCommand());
        Position pos = new Position(this.x,this.y);
        this.observableCell.notifyObservers(numero,pos);
    }
}