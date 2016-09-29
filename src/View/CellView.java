package View;

import javax.swing.*;

/**
 * Created by mariagustina on 25/09/16.
 *
 */
public abstract class CellView extends JPanel  {
    public int x; //posicion (1,1) ; (1,2) ; (2,1)..etc
    public int y;

    public CellView(int x, int y){
        this.x = x;
        this.y = y;
    }
}
