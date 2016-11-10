package ar.fiuba.tdd.template.tp1;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class RuleDeserializer implements JsonDeserializer<Rule> {

    private static final Map<String,Rule> rules;

    static {
        rules = new HashMap<>();
        rules.put("AllDifferentRule", new AllDifferentRule());
        rules.put("SumOfNumbersEqXRule", new SumOfNumbersEqXRule());
        rules.put("MultiplyNumbersEqXRule", new MultiplyNumbersEqXRule());
        rules.put("NumberElementVisitedRule", new NumberElementVisitedRule());
        rules.put("NumberInternalJoinsRule", new NumberInternalJoinsRule());
        rules.put("NotClosedPathRule", new NotClosedPathRule());
        rules.put("CellsBetweenGECellValueRule", new CellsBetweenGECellValueRule());
        rules.put("TwoConsecutiveBlackCellRule", new TwoConsecutiveBlackCellRule());
    }

    @Override
    public Rule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("rule");
        String rule = jsonType.getAsString();

        return rules.get(rule);
    }
}
