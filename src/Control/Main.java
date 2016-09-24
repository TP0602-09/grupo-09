package Control;
import View.CellVIew;

import javax.swing.*;
public class Main {

    public static void sayHello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        sayHello();
        mainGraphics();
    }

    public static void mainGraphics(){
        ViewController vc = new ViewController();

        JLabel label = new JLabel("Hello World");
        vc.renderView(label);

        CellVIew cell = new CellVIew();
        vc.renderView(cell);
    }
}