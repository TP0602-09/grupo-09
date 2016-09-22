package Control;

public class Main {

    public static void sayHello() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        EngineController engineController = new EngineController("SUDOKU");
        EngineController engineKakuroController = new EngineController("KAKURO");
    }
}