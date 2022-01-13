package bad.domain.codition;

import bad.domain.Movie;
import bad.domain.Screening;
import bad.domain.policy.DiscountPolicy;

import java.time.LocalDateTime;

public interface DiscountCondition {
    public boolean isDiscountable(Screening screening);
}
