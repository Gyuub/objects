package domain.policy.addition;

import domain.Money;
import domain.Phone;

public abstract class AdditionPolicy implements FeePolicy {

    FeePolicy feePolicy;

    public AdditionPolicy(FeePolicy feePolicy) {
        this.feePolicy = feePolicy;
    }

    @Override
    public Money getCalculateFee(Phone phone) {
        Money result = feePolicy.getCalculateFee(phone);
        return afterCalculate(result);
    }

    public abstract Money afterCalculate(Money fee);
}
