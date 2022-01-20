package domain.calculator;

import domain.Call;
import domain.Money;

import java.time.Duration;

public class RegularCalculator extends DefaultCalculator {
    private Money amount;
    private Duration secound;
    public RegularCalculator(Money amount, Duration secound) {
        this.secound = secound;
        this.amount = amount;
    }

    @Override
    public Money calculate(Call call) {
        return amount.times(call.getDuration().getSeconds() / secound.getSeconds());
    }
}
