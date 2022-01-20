package domain.calculator;

import domain.Call;
import domain.Money;

import java.time.Duration;

public class RegularCalculator extends DefaultCalculator {
    public RegularCalculator(Duration secound, Money amount) {
        super(secound, amount);
    }

    @Override
    protected boolean isSatisfiedBy(Call call) {
        return true;
    }

    @Override
    public Money calculate(Call call) {
        return amount.times(call.getDuration().getSeconds() / secound.getSeconds());
    }
}
