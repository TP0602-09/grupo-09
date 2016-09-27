package Model;

import java.util.ArrayList;

/**
 * Created by mariagustina on 26/09/16.
 */
public class RuleNotSameNumber extends Rule {

    public boolean validateSection(ArrayList<Cell> cells){
       /* for (int i=0 ; i< cells.size();i++){
            imprimirPosisicion(cells.get(i).getPosition());
            System.out.println(cells.get(i).getValue());
        }*/
        return checkDuplicatedValues(cells);
    }

    private boolean checkDuplicatedValues(ArrayList<Cell> cells){
        for (int i = 0; i < cells.size(); i++){
            for (int j = i+1 ; j < cells.size() - i ; j++){
                int value1 = cells.get(i).getValue();
                int value2 = cells.get(j).getValue();
                if(!areValidValues(value1,value2)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areValidValues(int value1,int value2){
        if ((value1 == 0) || (value2 == 0)){
            return true;
        }
        if (value1 != value2){
            return true;
        }
        return false;
    }

    public void imprimirPosisicion(Position pos){
        System.out.print(" Posicion: [ ");
        System.out.print(pos.getX());
        System.out.print(" , ");
        System.out.print(pos.getY());
        System.out.println(" ]");

    }
}
