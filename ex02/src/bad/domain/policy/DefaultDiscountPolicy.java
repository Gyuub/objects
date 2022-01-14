package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;
import bad.domain.Screening;
import bad.domain.codition.DiscountCondition;

import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{
    private List<DiscountCondition> discountConditions;

    public DefaultDiscountPolicy(DiscountCondition ...discountConditions) {
        this.discountConditions = Arrays.asList(discountConditions);
    }

    protected abstract Money getDiscountedFee(Screening screening);

    @Override
    public Money calculateDiscountedFee(Screening screening) {
        if(isSatisfiedBy(screening)){
            return screening.getMovieFee().minus(getDiscountedFee(screening));
        }
        return screening.getMovieFee();
    }

    private boolean isSatisfiedBy(Screening screening) {
        return discountConditions.stream()
                .anyMatch(codition -> codition.isDiscountable(screening));
    }

}
