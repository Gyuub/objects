package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;

public class NoneDiscountPolicy implements DiscountPolicy{
    @Override
    public Money calculateDiscountedFee(Movie movie) {
        return Money.ZERO;
    }
}
