package ar.fiuba.tdd.template.tp1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputFileReader {

    public InputData read(String name) throws IOException {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Play.class, new PlayDeserializer());
        Gson gson = gsonBuilder.create();
        String path = System.getProperty("user.dir") + "/resources/" + name + ".json";
        try {
            InputStreamReader jsonFile = new InputStreamReader(new FileInputStream(path), "UTF-8");

            return gson.fromJson(jsonFile, InputData.class);

        } catch (IOException e) {
            throw e;
        }
    }
}
