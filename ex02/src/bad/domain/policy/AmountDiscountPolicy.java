package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;
import bad.domain.Screening;
import bad.domain.codition.DiscountCondition;
import bad.domain.codition.PeriodCondition;
import bad.domain.codition.SequenceCondition;

import java.math.BigDecimal;
import java.util.List;

public class AmountDiscountPolicy extends DefaultDiscountPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition ... discountConditions ) {
        super(discountConditions);
        this.discountAmount = discountAmount;
    }
    @Override
    protected Money getDiscountedFee(Screening screening) {
        return discountAmount;
    }
}
