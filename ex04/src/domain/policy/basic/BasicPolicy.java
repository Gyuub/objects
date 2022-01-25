package domain.policy.basic;

import domain.Call;
import domain.Money;
import domain.Phone;
import domain.policy.addition.FeePolicy;
import domain.policy.good.FeeRule;

import java.util.ArrayList;
import java.util.List;

public class BasicPolicy implements FeePolicy {
    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicPolicy(List<FeeRule> feeRules) {
        this.feeRules = feeRules;
    }

    @Override
    public Money getCalculateFee(Phone phone){
        Money result = Money.ZERO;
        for (Call each : phone.getCalls()) {
            result = result.plus(calculate(each));
        }
        return result;
    }
    private Money calculate(Call call){
        return feeRules
                .stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, (first, second) -> first.plus(second));
    }



}
