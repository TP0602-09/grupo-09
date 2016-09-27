package Control;
public class Main {

    public static void sayHello() {
        System.out.println("Welcome to Nikoli's Game Generator Engine");
    }

    public static void main(String[] args) {
        sayHello();
        mainGame();
    }

    public static void mainGame(){
        EngineController ec = new EngineController("SUDOKU");

    }

}