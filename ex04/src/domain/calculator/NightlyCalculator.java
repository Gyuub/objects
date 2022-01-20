package domain.calculator;

import domain.Call;
import domain.Money;
import domain.Phone;

import java.time.Duration;

public class NightlyCalculator extends DefaultCalculator {
    private final int LATE_NIGHT_HOUR = 22;

    public NightlyCalculator(Duration secound, Money amount) {
        super(secound, amount);
    }

    @Override
    protected boolean isSatisfiedBy(Call call) {
        return call.getFrom().getHour() >= LATE_NIGHT_HOUR;
    }


    @Override
    protected Money calculate(Call call) {
        return amount.times(call.getDuration().getSeconds()/secound.getSeconds());

    }
}
