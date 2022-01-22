package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.time.Duration;

public class RegularPolicy extends BascicPolicy {
    private Money amount;
    private Duration secound;

    public RegularPolicy(Money amount, Duration secound) {
        this.secound = secound;
        this.amount = amount;
    }

    @Override
    public Money calculate(Call call) {
        return amount.times(call.getDuration().getSeconds() / secound.getSeconds());
    }
}
