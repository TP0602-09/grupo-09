package Model;

import java.util.HashMap;

public class CornerValues {

    private HashMap<Corner,Integer> cornersValues;
    public  CornerValues() {
        cornersValues = new HashMap<Corner,Integer>();
    }

    public int getUpperRight() {
        return cornersValues.get(Corner.UPPERRIGHT) != null ?
                cornersValues.get(Corner.UPPERRIGHT):0;
    }

    public int getUpperLeft() {
        return cornersValues.get(Corner.UPPERLEFT) != null ?
                cornersValues.get(Corner.UPPERLEFT):0;
    }

    public int getDownRight() {
        return cornersValues.get(Corner.DOWNRIGHT) != null ?
                cornersValues.get(Corner.DOWNRIGHT):0;
    }

    public int getDowmLeft() {
        return cornersValues.get(Corner.DOWNLEFT) != null ?
                cornersValues.get(Corner.DOWNLEFT):0;
    }
    public void setUpperRight(int upperRight) {
        cornersValues.put(Corner.UPPERRIGHT,upperRight);
    }

    public void setUpperLeft(int upperLeft) {
        cornersValues.put(Corner.UPPERLEFT,upperLeft);
    }
    public void setDownRight(int downRight) {
        cornersValues.put(Corner.DOWNRIGHT,downRight);
    }
    public void setDownLeft(int downLeft) {
        cornersValues.put(Corner.DOWNLEFT,downLeft);
    }

}
