package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Lucía on 16/10/2016.
 */
public class GameReader {
    private static GameReader ourInstance = new GameReader();

    public static GameReader getInstance() {
        return ourInstance;
    }

    private GameReader() {
    }

    public GameData readGameConfiguration(String gameName) throws GameNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        try {

            String path = System.getProperty("user.dir") + "/resources/Model/" + gameName + "/"
                    + gameName + "_enunciado.json";

            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(path), "UTF-8");

            GameData game = gson.fromJson(jsonFile, GameData.class);
            System.out.println("Configuracion del juego \'" + gameName + "\' leida exitosamente!");

            return game;

        } catch (IOException e) {
            throw new GameNotFoundException("No se ha encontrado el juego requerido");
        }

    }
}
