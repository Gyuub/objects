package domain.policy.condition;

import domain.DateTimeInterval;
import domain.Money;

import java.time.Duration;

public class FeePerDuration {
    private Money fee;
    private Duration duration;

    public FeePerDuration(Money fee, Duration duration) {
        this.fee = fee;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval){
        return fee.times(Math.ceil((double)interval.getDuration().toNanos() / duration.toNanos()));
    }
}
