package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;

public class AmountDiscountPolicy implements DiscountPolicy{
    @Override
    public Money calculateDiscountedFee(Movie movie) {
        return movie.getFee().minus(movie.getDiscountAmount());
    }
}
