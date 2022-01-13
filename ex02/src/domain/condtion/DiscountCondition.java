package domain.condtion;

import domain.Screening;

public interface DiscountCondition  {
    public boolean isSatisfiedBy(Screening screening);

}
