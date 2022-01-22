package domain.policy.addition;

import domain.Call;
import domain.Money;
import domain.Phone;
import domain.policy.FeePolicy;

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
