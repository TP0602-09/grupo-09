package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mariagustina on 25/09/16.
 *
 */
public class DataCellView extends CellView{
    private JFormattedTextField cell;

    public DataCellView(int x, int y,int value) {

        super(x,y);

        cell = new JFormattedTextField();
        cell.setPreferredSize( new Dimension( 20, 20 ) );
        cell.setHorizontalAlignment(SwingConstants.CENTER);
        cell.setEnabled(false);

        if (value == 0){
            cell.setBackground(Color.black);
        }else{
            cell.setBackground(new Color(239, 255, 165));
            cell.setValue(value);
            cell.setDisabledTextColor(Color.black);
        }

        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.setBackground(Color.blue);
        fieldPane.add(cell);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );

        add(fieldPane);


    }
}
