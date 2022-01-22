package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.time.Duration;

public class NightlyPolicy extends BascicPolicy {
    private final int LATE_NIGHT_HOUR = 22;
    private Money regularAmount;
    private Money nightlyAmount;
    private Duration second;

    public NightlyPolicy(Money regularAmount, Money nightlyAmount, Duration second) {
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
