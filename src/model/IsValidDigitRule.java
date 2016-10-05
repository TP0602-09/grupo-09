package model;

import java.util.List;

/**
 * Created by Lucía on 4/10/2016.
 */
public class IsValidDigitRule extends Rule {
    private static IsValidDigitRule ourInstance = new IsValidDigitRule();

    public static IsValidDigitRule getInstance() {
        return ourInstance;
    }

    private IsValidDigitRule() {
    }

    public boolean isValid(List<Cell> cells) {
        List<Integer> values = utils.extractValues(cells);

        return isValidDigit(values.get(0));
    }

    private boolean isValidDigit(Integer digit) {
        return digit > 0 && digit < 10;
    }
}
