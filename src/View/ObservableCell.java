package view;

import model.Position;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by mariagustina on 26/09/16.
 *
 */
public class ObservableCell extends Observable {
    private ArrayList<Object> message;

    public ObservableCell(){
        this.message = new ArrayList<Object>();
    }

/*    protected ArrayList<Object> getMessage() {
        return message;
    }*/

    public void changeMessage(ArrayList<Object> message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }

    public void notifyObservers(int value, Position pos){
        System.out.print("Notifico a los observers");
        this.message = new ArrayList<Object>();
        this.message.add(value);
        this.message.add(pos);
        System.out.println(value);
        changeMessage(this.message);
        notifyObservers("se cambio la celda");
    }
}
