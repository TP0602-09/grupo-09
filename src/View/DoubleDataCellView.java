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


        JPanel panel = this.getJpanel(value1,value2);

        JPanel fieldPane = new JPanel(new BorderLayout());
        fieldPane.setPreferredSize(new Dimension(30,30));
        fieldPane.add(panel);
        fieldPane.setMaximumSize( fieldPane.getPreferredSize() );
        add(fieldPane);

    }

    private JPanel getJpanel(final int value1, final int value2){
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);
                super.setBackground(Color.white);

                int xPoly[] = {0, 30, 0};
                int yPoly[] = {0, 30, 30};
                //dibujo la diagonal
                Polygon leftPoly = new Polygon(xPoly, yPoly, yPoly.length);
                g.setColor(Color.BLACK);
                g.drawPolygon(leftPoly);

                if(value1 == 0){
                    this.paintNoneValueLeftCell(g,xPoly,yPoly,Color.black);
                }

                int xPoly2[] = {0, 30, 30};
                int yPoly2[] = {0, 0, 30};

                if(value2 == 0) {
                    this.paintNoneValueRightCell(g, xPoly2, yPoly2, Color.black);
                }
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

        JLabel leftLabel = new JLabel(Integer.toString(value1));
        leftLabel.setFont (leftLabel.getFont ().deriveFont (10.0f));
        JLabel rightLabel = new JLabel(Integer.toString(value2));
        rightLabel.setFont (rightLabel.getFont ().deriveFont (10.0f));

        if(value1 != 0 && value2 == 0){ //hay label a la izq
            panel.setLayout(new FlowLayout(FlowLayout.LEFT, 3, 15));
            panel.add(leftLabel);

        }else if (value1 == 0 && value2 !=0){ //hay label a la der
            panel.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 5));
            panel.add(rightLabel);

        }else{//los dos tienen label
           // panel.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 8));
            leftLabel.setAlignmentY(20);
            rightLabel.setAlignmentY(28);
            panel.add(leftLabel);
            panel.add(rightLabel);
        }


        return panel;
    }
}
