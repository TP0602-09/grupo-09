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
            int x = jsonObject.get("position").getAsJsonArray().get(0).getAsInt();
            int y = jsonObject.get("position").getAsJsonArray().get(1).getAsInt();
            valuePlay.setPosition(new Position(x,y));
            valuePlay.setValue(jsonObject.get("value").getAsInt());
            play = valuePlay;
        } else if ("join".equals(type)) {
            JoinPlay joinPlay = new JoinPlay();
            int x = jsonObject.get("firstPosition").getAsJsonArray().get(0).getAsInt();
            int y = jsonObject.get("firstPosition").getAsJsonArray().get(1).getAsInt();
            joinPlay.setFirstPosition(new Position(x,y));
            x = jsonObject.get("secondPosition").getAsJsonArray().get(0).getAsInt();
            y = jsonObject.get("secondPosition").getAsJsonArray().get(1).getAsInt();
            joinPlay.setFirstPosition(new Position(x,y));
            play = joinPlay;
        }

        return play;
    }
}
