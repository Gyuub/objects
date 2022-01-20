package domain.calculator;

import domain.Call;
import domain.Money;
import domain.Phone;

import java.time.Duration;

public class NightlyCalculator extends DefaultCalculator {
    private final int LATE_NIGHT_HOUR = 22;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration second;

    public NightlyCalculator(Money regularAmount, Money nightlyAmount, Duration second) {
        this.regularAmount = regularAmount;
        this.nightlyAmount = nightlyAmount;
        this.second = second;
    }

    protected boolean isSatisfiedBy(Call call) {
        return call.getFrom().getHour() >= LATE_NIGHT_HOUR;
    }


    @Override
    protected Money calculate(Call call) {
        if(isSatisfiedBy(call)){
            return nightlyAmount.times(call.getDuration().getSeconds()/second.getSeconds());
        }
        return regularAmount.times(call.getDuration().getSeconds()/second.getSeconds());
    }
}
