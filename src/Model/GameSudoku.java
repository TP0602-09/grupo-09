package Model;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Created by mariagustina on 22/09/16.
 */
public class GameSudoku extends Game{

    public void Game(){
    }

    public void startConfiguration(){

        System.out.println("Configuracion, aca le pasamos lo que levanta del json inicial");

        //TODO: JSON!!!!!!!!!!!!!!!

        ArrayList arrayDic = new ArrayList();

        //CELDA 1
        HashMap cellMap1 = new HashMap<String, Object>();
        ArrayList position = new ArrayList();
        position.add(1);
        position.add(7);
        cellMap1.put("pos", position);
        cellMap1.put("value",7);
        cellMap1.put("type", "dat");
        arrayDic.add(cellMap1);

        //CELDA 2
        HashMap cellMap2 = new HashMap<String, Object>();
        ArrayList position2 = new ArrayList();
        position2.add(1);
        position2.add(8);
        cellMap2.put("pos", position2);
        cellMap2.put("type", "dat");
        cellMap2.put("value",3);
        arrayDic.add(cellMap2);


        HashMap cellMap3 = new HashMap<String, Object>();
        ArrayList position3 = new ArrayList();
        position3.add(2);
        position3.add(2);
        cellMap3.put("pos", position3);
        cellMap3.put("type", "dat");
        cellMap3.put("value",9);
        arrayDic.add(cellMap3);


        HashMap cellMap4 = new HashMap<String, Object>();
        ArrayList position4 = new ArrayList();
        position4.add(2);
        position4.add(3);
        cellMap4.put("pos", position4);
        cellMap4.put("type", "dat");
        cellMap4.put("value",4);
        arrayDic.add(cellMap4);

        HashMap cellMap5 = new HashMap<String, Object>();
        ArrayList position5 = new ArrayList();
        position5.add(3);
        position5.add(6);
        cellMap5.put("pos", position5);
        cellMap5.put("type", "dat");
        cellMap5.put("value",7);
        arrayDic.add(cellMap5);

        HashMap cellMap6 = new HashMap<String, Object>();
        ArrayList position6 = new ArrayList();
        position6.add(3);
        position6.add(7);
        cellMap6.put("pos", position6);
        cellMap6.put("type", "dat");
        cellMap6.put("value",8);
        arrayDic.add(cellMap6);

        HashMap cellMap7 = new HashMap<String, Object>();
        ArrayList position7 = new ArrayList();
        position7.add(3);
        position7.add(9);
        cellMap7.put("pos", position7);
        cellMap7.put("type", "dat");
        cellMap7.put("value",1);
        arrayDic.add(cellMap7);

        HashMap cellMap8 = new HashMap<String, Object>();
        ArrayList position8 = new ArrayList();
        position8.add(4);
        position8.add(1);
        cellMap8.put("pos", position8);
        cellMap8.put("type", "dat");
        cellMap8.put("value",5);
        arrayDic.add(cellMap8);

        HashMap cellMap9 = new HashMap<String, Object>();
        ArrayList position9 = new ArrayList();
        position9.add(4);
        position9.add(2);
        cellMap9.put("pos", position9);
        cellMap9.put("type", "dat");
        cellMap9.put("value",3);
        arrayDic.add(cellMap9);

        HashMap cellMap10 = new HashMap<String, Object>();
        ArrayList position10 = new ArrayList();
        position10.add(4);
        position10.add(3);
        cellMap10.put("pos", position10);
        cellMap10.put("type", "dat");
        cellMap10.put("value",9);
        arrayDic.add(cellMap10);

        HashMap cellMap11 = new HashMap<String, Object>();
        ArrayList position11 = new ArrayList();
        position11.add(4);
        position11.add(7);
        cellMap11.put("pos", position11);
        cellMap11.put("type", "dat");
        cellMap11.put("value",6);
        arrayDic.add(cellMap11);

        HashMap cellMap12 = new HashMap<String, Object>();
        ArrayList position12 = new ArrayList();
        position12.add(5);
        position12.add(4);
        cellMap12.put("pos", position12);
        cellMap12.put("type", "dat");
        cellMap12.put("value",4);
        arrayDic.add(cellMap12);

        HashMap cellMap13 = new HashMap<String, Object>();
        ArrayList position13 = new ArrayList();
        position13.add(5);
        position13.add(6);
        cellMap13.put("pos", position13);
        cellMap13.put("type", "dat");
        cellMap13.put("value",5);
        arrayDic.add(cellMap13);


        HashMap cellMap14 = new HashMap<String, Object>();
        ArrayList position14 = new ArrayList();
        position14.add(5);
        position14.add(7);
        cellMap14.put("pos", position14);
        cellMap14.put("type", "dat");
        cellMap14.put("value",2);
        arrayDic.add(cellMap14);

        HashMap cellMap15 = new HashMap<String, Object>();
        ArrayList position15 = new ArrayList();
        position15.add(6);
        position15.add(1);
        cellMap15.put("pos", position15);
        cellMap15.put("type", "dat");
        cellMap15.put("value",1);
        arrayDic.add(cellMap15);

        HashMap cellMap16 = new HashMap<String, Object>();
        ArrayList position16 = new ArrayList();
        position16.add(6);
        position16.add(6);
        cellMap16.put("pos", position16);
        cellMap16.put("type", "dat");
        cellMap16.put("value",9);
        arrayDic.add(cellMap16);



        HashMap cellMap17 = new HashMap<String, Object>();
        ArrayList position17 = new ArrayList();
        position17.add(7);
        position17.add(1);
        cellMap17.put("pos", position17);
        cellMap17.put("type", "dat");
        cellMap17.put("value",3);
        arrayDic.add(cellMap17);

        HashMap cellMap18 = new HashMap<String, Object>();
        ArrayList position18 = new ArrayList();
        position18.add(7);
        position18.add(2);
        cellMap18.put("pos", position18);
        cellMap18.put("type", "dat");
        cellMap18.put("value",7);
        arrayDic.add(cellMap18);

        HashMap cellMap19 = new HashMap<String, Object>();
        ArrayList position19 = new ArrayList();
        position19.add(7);
        position19.add(5);
        cellMap19.put("pos", position19);
        cellMap19.put("type", "dat");
        cellMap19.put("value",5);
        arrayDic.add(cellMap19);

        HashMap cellMap20 = new HashMap<String, Object>();
        ArrayList position20 = new ArrayList();
        position20.add(7);
        position20.add(6);
        cellMap20.put("pos", position20);
        cellMap20.put("type", "dat");
        cellMap20.put("value",6);
        arrayDic.add(cellMap20);

        HashMap cellMap21 = new HashMap<String, Object>();
        ArrayList position21 = new ArrayList();
        position21.add(8);
        position21.add(3);
        cellMap20.put("pos", position21);
        cellMap20.put("type", "dat");
        cellMap20.put("value",6);
        arrayDic.add(cellMap21);

        HashMap cellMap22 = new HashMap<String, Object>();
        ArrayList position22 = new ArrayList();
        position22.add(9);
        position22.add(4);
        cellMap22.put("pos", position22);
        cellMap22.put("type", "dat");
        cellMap22.put("value",1);
        arrayDic.add(cellMap22);


        HashMap cellMap23 = new HashMap<String, Object>();
        ArrayList position23 = new ArrayList();
        position23.add(9);
        position23.add(9);
        cellMap23.put("pos", position23);
        cellMap23.put("type", "dat");
        cellMap23.put("value",3);
        arrayDic.add(cellMap23);

        this.board = new Board(9,9,arrayDic);

    }

    public void startGame(){
        System.out.println("Welcome to Sudoku");
        startConfiguration();
    }
}
