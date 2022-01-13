package domain.policy;

import domain.Money;
import domain.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
