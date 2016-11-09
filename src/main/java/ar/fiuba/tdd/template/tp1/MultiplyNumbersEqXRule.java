package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;

/**
 * Created by Lucía on 19/10/2016.
 */
public class MultiplyNumbersEqXRule extends OperationOfNumbersEqXRule {

    @Override
    public Integer operation(ArrayList<Integer> values) {
        Integer sum = 1;
        for (Integer value: values) {
            sum *= value;
        }
        return sum;
    }

}
