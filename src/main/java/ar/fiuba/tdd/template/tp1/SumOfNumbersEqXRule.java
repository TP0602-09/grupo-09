package ar.fiuba.tdd.template.tp1;

import java.util.ArrayList;

/**
 * Created by Lucía on 17/10/2016.
 */
public class SumOfNumbersEqXRule extends OperationOfNumbersEqXRule {

    @Override
    public Integer operation(ArrayList<Integer> values) {
        Integer sum = 0;
        for (Integer value: values) {
            sum += value;
        }
        return sum;
    }

}
