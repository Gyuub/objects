package domain.policy.addition;

import domain.Money;

public class AmountDiscountPolicy extends AdditionPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(FeePolicy feePolicy, Money discountAmount) {
        super(feePolicy);
        this.discountAmount = discountAmount;
    }

    @Override
    public Money afterCalculate(Money fee) {
        return fee.minus(discountAmount);
    }
}
