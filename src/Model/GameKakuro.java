package Model;

/**
 * Created by mariagustina on 22/09/16.
 */
public class GameKakuro extends Game {

    public void Game(){

    }

    public void startConfiguration(){
        System.out.println("Configuracion, aca le pasamos lo que levanta del json inicial");
    }
    public void startGame(){
        System.out.println("Welcome to Kakuro");
    }

    public boolean validate(Cell cell){
        //TODO
        return true;
    }
}
