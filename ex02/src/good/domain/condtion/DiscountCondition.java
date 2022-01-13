package good.domain.condtion;

import good.domain.Screening;

public interface DiscountCondition  {
    public boolean isSatisfiedBy(Screening screening);

}
