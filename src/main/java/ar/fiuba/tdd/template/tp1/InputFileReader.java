package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Lucía on 18/10/2016.
 */
public class InputFileReader {

    public InputData read(String path) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Play.class, new PlayDeserializer());
        Gson gson = gsonBuilder.create();

        try {
            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(path), "UTF-8");

            return gson.fromJson(jsonFile, InputData.class);

        } catch (IOException e) {
            throw e;
        }
    }
}
