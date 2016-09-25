package Model;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Created by mariagustina on 22/09/16.
 */
public class GameSudoku extends Game{
    public void Game(){
        getConfiguration();
    }

    public void getConfiguration(){

        System.out.println("Configuracion, aca le pasamos lo que levanta del json inicial");

        //TODO: JSON!!!!!!!!!!!!!!!

        ArrayList arrayDic = new ArrayList();

        //CELDA 1
        HashMap cellMap1 = new HashMap<String, String>();
        ArrayList position = new ArrayList();
        position.add(1);
        position.add(7);
        cellMap1.put("pos", position);
        cellMap1.put("value",7);
        cellMap1.put("type", "dat");
        arrayDic.add(cellMap1);

        //CELDA 2
        HashMap cellMap2 = new HashMap<String, String>();
        ArrayList position2 = new ArrayList();
        position2.add(1);
        position2.add(8);
        cellMap2.put("pos", position2);
        cellMap1.put("type", "dat");
        arrayDic.add(cellMap2);

        this.board = new Board(9,9,arrayDic);

    }
    public void startGame(){
        System.out.println("Welcome to Sudoku");
    }
}
