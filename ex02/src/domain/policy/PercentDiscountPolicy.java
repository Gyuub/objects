package domain.policy;

import domain.Money;
import domain.Screening;
import domain.condtion.DiscountCondition;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    public Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
