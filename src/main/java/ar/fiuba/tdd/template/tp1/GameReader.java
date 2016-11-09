package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class GameReader {
    private static GameReader ourInstance = new GameReader();

    public static GameReader getInstance() {
        return ourInstance;
    }

    private GameReader() {
    }

    public GameData readGameConfiguration(String gameName) throws GameNotFoundException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(BoardElement.class, new BoardElementDeserializer());
        gsonBuilder.registerTypeAdapter(Rule.class, new RuleDeserializer());
        Gson gson = gsonBuilder.create();

        try {

            String path = System.getProperty("user.dir") + "/resources/" + gameName + ".json";

            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(path), "UTF-8");

            GameData game = gson.fromJson(jsonFile, GameData.class);
            System.out.println("Configuration of game \'" + gameName + "\' successfully read!");

            return game;

        } catch (IOException e) {
            throw new GameNotFoundException("We haven't found your game =(");
        }

    }
}
