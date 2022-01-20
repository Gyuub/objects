package domain.calculator;

import domain.Call;
import domain.Money;
import domain.Phone;
import domain.calculator.DefaultCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappedCalculator extends DefaultCalculator {

    List<DefaultCalculator> defaultCalculators = new ArrayList<>();

    public OverlappedCalculator(DefaultCalculator ...defaultCalculators) {
        this.defaultCalculators = Arrays.asList(defaultCalculators);
    }

    @Override
    protected boolean isSatisfiedBy(Call call) {
        return false;
    }

    @Override
    protected Money calculate(Call call) {
        Money result = Money.ZERO;
        for (DefaultCalculator calculator : defaultCalculators) {
            if(calculator.isSatisfiedBy(call)){
                result = calculator.calculate(call);
            }
        }
        return result;
    }
}
