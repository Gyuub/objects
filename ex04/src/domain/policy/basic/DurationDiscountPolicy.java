package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.util.ArrayList;
import java.util.List;

public class DurationDiscountPolicy extends BascicPolicy{

    private List<DurationDiscountRule> rules = new ArrayList<>();
    @Override
    protected Money calculate(Call call) {
        Money result = Money.ZERO;
        for(DurationDiscountRule rule : rules){
            result.plus(rule.calculate(call));
        }
        return result;
    }



}
