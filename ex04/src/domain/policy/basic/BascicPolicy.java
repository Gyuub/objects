package domain.policy.basic;

import domain.Call;
import domain.Money;
import domain.Phone;
import domain.policy.FeePolicy;

public abstract class BascicPolicy implements FeePolicy {

    @Override
    public Money getCalculateFee(Phone phone){
        Money result = Money.ZERO;
        for (Call each : phone.getCalls()) {
            result = result.plus(calculate(each));
        }
        return result;
    }

    protected abstract Money calculate(Call call);


}
