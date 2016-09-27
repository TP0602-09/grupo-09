/**
 * Created by Ignacio Galvez on 27/9/2016.
 */
package Model;


public class SudokuBoardFactoryTest {


    public static void main(String[] args) {
        SudokuBoardFactory factory = new SudokuBoardFactory();
        Board board = factory.create();
        assert board != null;
    }
}