package Control;

import View.HelloWorldSwing;

public class Main {

    public static void sayHello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        sayHello();
        mainGraphics();
    }

    public static void mainGraphics(){
        HelloWorldSwing hw = new HelloWorldSwing();
        hw.render();
    }
}