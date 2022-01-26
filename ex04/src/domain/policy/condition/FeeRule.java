package domain.policy.condition;

import domain.Call;
import domain.Money;

public class FeeRule {
    private FeeCondition feeCondition;
    private FeePerDuration feePerDuration;

    public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
        this.feeCondition = feeCondition;
        this.feePerDuration = feePerDuration;
    }

    public Money calculateFee(Call call){
        return feeCondition.findTimeIntervals(call)
                .stream()
                .map(o -> feePerDuration.calculate(o))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }
}
