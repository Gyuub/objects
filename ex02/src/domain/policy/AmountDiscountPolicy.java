package domain.policy;

import domain.Money;
import domain.Screening;
import domain.condtion.DiscountCondition;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
