package domain.policy.basic;

import domain.Call;
import domain.DateTimeInterval;
import domain.Money;
import domain.Phone;

import java.time.Duration;

public class DurationDiscountRule extends FixedFeePolicy {
    private Duration from;
    private Duration to;

    public DurationDiscountRule(Money amount, Duration secound, Duration from, Duration to) {
        super(amount, secound);
        this.from = from;
        this.to = to;
    }

    public Money calculate(Call call) {
        if (call.getDuration().compareTo(to) > 0) {
            return Money.ZERO;
        }
        if (call.getDuration().compareTo(from) < 0){
            return Money.ZERO;
        }

        Phone phone = new Phone(null);
        DateTimeInterval interval = new DateTimeInterval(call.getFrom().plus(from),
                call.getDuration().compareTo(to) > 0 ? call.getFrom().plus(to) : call.getTo());
        phone.call(new Call(interval));

        return super.calculate(call);
    }
}
