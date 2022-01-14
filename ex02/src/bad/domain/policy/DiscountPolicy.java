package bad.domain.policy;

import bad.domain.Money;
import bad.domain.Movie;
import bad.domain.Screening;

public interface DiscountPolicy {

    public Money calculateDiscountedFee(Screening screening);
}
