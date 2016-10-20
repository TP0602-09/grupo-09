package ar.fiuba.tdd.template.tp1;

import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Lucía on 20/10/2016.
 */
public class PlayDeserializer implements JsonDeserializer<Play> {

    @Override
    public Play deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("type");
        String type = jsonType.getAsString();

        Play play = null;

        if ("value".equals(type)) {
            ValuePlay valuePlay = new ValuePlay();
            int posX = jsonObject.get("position").getAsJsonArray().get(0).getAsInt();
            int posY = jsonObject.get("position").getAsJsonArray().get(1).getAsInt();
            valuePlay.setPosition(new Position(posX,posY));
            valuePlay.setValue(jsonObject.get("value").getAsInt());
            play = valuePlay;
        } else if ("join".equals(type)) {
            JoinPlay joinPlay = new JoinPlay();
            int posX = jsonObject.get("firstPosition").getAsJsonArray().get(0).getAsInt();
            int posY = jsonObject.get("firstPosition").getAsJsonArray().get(1).getAsInt();
            joinPlay.setFirstPosition(new Position(posX,posY));
            posX = jsonObject.get("secondPosition").getAsJsonArray().get(0).getAsInt();
            posY = jsonObject.get("secondPosition").getAsJsonArray().get(1).getAsInt();
            joinPlay.setSecondPosition(new Position(posX,posY));
            play = joinPlay;
        }

        return play;
    }
}
