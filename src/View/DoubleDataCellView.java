package View;
import javax.swing.*;
import java.awt.*;
/**
 * Created by mariagustina on 25/09/16.
 */
public class DoubleDataCellView extends CellView {

    private JPanel leftTriangle;
    private JPanel rightTriangle;

    public DoubleDataCellView(int x, int y,int value1,int value2) {
        super(x,y);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                super.setBackground(Color.white);


                int xPoly[] = {0, 30, 0};
                int yPoly[] = {0, 30, 30};
                this.paintNoneValueLeftCell(g,xPoly,yPoly,Color.blue);


                int xPoly2[] = {0, 30, 30};
                int yPoly2[] = {0, 0, 30};
                this.paintNoneValueRightCell(g,xPoly2,yPoly2,Color.red);
            }


            @Override
            public Dimension getPreferredSize() {
                return new Dimension(30, 30);
            }

            private void paintNoneValueLeftCell(Graphics g,int initXPoly[],int initYPoly[],Color color) {
                int dimension = 30;

                while (dimension>=0) {

                    initXPoly[0] =0;
                    initXPoly[1] = dimension;
                    initXPoly[2] = 0;

                    initYPoly[0] = 0;
                    initYPoly[1] = dimension;
                    initYPoly[2] = dimension;

                    Polygon leftPoly = new Polygon(initXPoly, initYPoly, initYPoly.length);

                    g.setColor(color);
                    g.drawPolygon(leftPoly);
                    dimension--;
                }
            }

            private void paintNoneValueRightCell(Graphics g,int initXPoly[],int initYPoly[],Color color) {
                int dimension = 30;

                while (dimension>=0) {

                    initXPoly[0] =0;
                    initXPoly[1] = dimension;
                    initXPoly[2] = dimension;

                    initYPoly[0] = 0;
                    initYPoly[1] = 0;
                    initYPoly[2] = dimension;

                    Polygon leftPoly = new Polygon(initXPoly, initYPoly, initYPoly.length);

                    g.setColor(color);
                    g.drawPolygon(leftPoly);
                    dimension--;
                }
            }

        };

        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.setBackground(Color.blue);
        fieldPane.add(panel);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );

        add(fieldPane);

    }

}
