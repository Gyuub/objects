package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.time.Duration;

public class FixedFeePolicy extends BasicPolicy {
    private Money amount;
    private Duration secound;

    public FixedFeePolicy(Money amount, Duration secound) {
        this.secound = secound;
        this.amount = amount;
    }

    @Override
    public Money calculate(Call call) {
        return amount.times(call.getDuration().getSeconds() / secound.getSeconds());
    }
}
