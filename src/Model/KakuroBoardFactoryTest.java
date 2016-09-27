package Model;

/**
 * Created by Ignacio on 27/9/2016.
 */


public class KakuroBoardFactoryTest {

    public static void main(String[] args) {
        KakuroBoardFactory factory = new KakuroBoardFactory();
        Board board = factory.create();
        assert board != null;
    }
}
