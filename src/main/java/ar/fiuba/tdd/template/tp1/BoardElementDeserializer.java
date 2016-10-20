package ar.fiuba.tdd.template.tp1;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Lucía on 20/10/2016.
 */
public class BoardElementDeserializer implements JsonDeserializer<BoardElement> {
    @Override
    public BoardElement deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("type");
        String type = jsonType.getAsString();

        BoardElement boardElement = null;

        if ("cell".equals(type)) {
            Cell cell = new Cell();
            cell.setValue(jsonObject.get("value").getAsInt());
            boardElement = cell;
        } else if ("vorterix".equals(type)) {
            boardElement = new Vorterix();
        }

        int x = jsonObject.get("position").getAsJsonArray().get(0).getAsInt();
        int y = jsonObject.get("position").getAsJsonArray().get(1).getAsInt();
        boardElement.setPosition(new Position(x,y));

        return boardElement;
    }
}
