package ar.fiuba.tdd.template.tp1;

import com.google.gson.*;

import java.lang.reflect.Type;

public class PlayDeserializer implements JsonDeserializer<Play> {

    @SuppressWarnings("CPD-START")
    @Override
    public Play deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        Play play = null;
        if ("value".equals(type)) {
            ValuePlay valuePlay = new ValuePlay();
            valuePlay.setPosition(getPosition(jsonObject, "position"));
            valuePlay.setValue(jsonObject.get("value").getAsInt());
            play = valuePlay;
        } else if ("join".equals(type)) {
            JoinPlay joinPlay = new JoinPlay();
            joinPlay.setFirstPosition(getPosition(jsonObject, "firstPosition"));
            joinPlay.setSecondPosition(getPosition(jsonObject, "secondPosition"));
            play = joinPlay;
        } else if ("undo".equals(type)) {
            UndoPlay undoPlay = new UndoPlay();
            play = undoPlay;
        }
        return play;
    }

    @SuppressWarnings("CPD-END")

    private Position getPosition(JsonObject jsonObject, String key) {
        int posX = jsonObject.get(key).getAsJsonArray().get(0).getAsInt();
        int posY = jsonObject.get(key).getAsJsonArray().get(1).getAsInt();
        return new Position(posX, posY);
    }
}
