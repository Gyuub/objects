package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;

public interface DiscountPolicy {

    public Money calculateDiscountedFee(Movie movie);
}
