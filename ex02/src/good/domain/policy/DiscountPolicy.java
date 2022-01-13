package good.domain.policy;

import good.domain.Money;
import good.domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
