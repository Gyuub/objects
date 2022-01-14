package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;
import bad.domain.Screening;
import bad.domain.codition.DiscountCondition;

import java.util.List;

public class PercentDiscountPolicy extends DefaultDiscountPolicy{
    private double discountPercent;

    public PercentDiscountPolicy(double discountPercent, DiscountCondition ...discountConditions) {
        super(discountConditions);
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money getDiscountedFee(Screening screening) {
        return screening.getMovieFee().minus(screening.getMovieFee().times((discountPercent)));
    }
}
