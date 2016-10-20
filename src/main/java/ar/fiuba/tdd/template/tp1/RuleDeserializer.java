package ar.fiuba.tdd.template.tp1;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lucía on 20/10/2016.
 */
public class RuleDeserializer implements JsonDeserializer<Rule> {

    private static final Map<String,Rule> reglas;
    static {
        reglas = new HashMap<String, Rule>();
        reglas.put("AllDifferentRule", new AllDifferentRule());
        reglas.put("SumOfNumbersEqXRule", new SumOfNumbersEqXRule());
    }

    @Override
    public Rule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("rule");
        String rule = jsonType.getAsString();

        return reglas.get(rule);
    }
}
