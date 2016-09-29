package View;

import Model.Position;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by mariagustina on 26/09/16.
 */
public class ObservableCell extends Observable {
    private ArrayList message;

    public ObservableCell(){
        this.message = new ArrayList();
    }

    public ArrayList getMessage() {
        return message;
    }

    public void changeMessage(ArrayList<Object> message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public void notifyObservers(int value, Position pos){
        System.out.print("Notifico a los observers");
        this.message.add(value);
        this.message.add(pos);
        changeMessage(this.message);
        notifyObservers("se cambio la celda");
    }
}
