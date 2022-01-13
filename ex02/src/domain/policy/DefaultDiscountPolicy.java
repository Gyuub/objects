package domain.policy;

import domain.Money;
import domain.Screening;
import domain.condtion.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    protected abstract Money getDiscountAmount(Screening screening);

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if(each.isSatisfiedBy(screening)){
                return getDiscountAmount(screening);
            }
        }
        return Money.ZERO;
    }


}
