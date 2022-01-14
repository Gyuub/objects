package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;
import bad.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy{

    @Override
    public Money calculateDiscountedFee(Screening screening) {
        return Money.ZERO;
    }
}
