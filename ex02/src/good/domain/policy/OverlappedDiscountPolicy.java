package good.domain.policy;

import good.domain.Money;
import good.domain.Screening;
import good.domain.condtion.DiscountCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OverlappedDiscountPolicy extends DefaultDiscountPolicy {

    private List<DefaultDiscountPolicy> discountPolicies = new ArrayList<>();

    public OverlappedDiscountPolicy(DefaultDiscountPolicy ...discountPolicies) {
        this.discountPolicies = Arrays.asList(discountPolicies);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;
        for (DiscountPolicy each:discountPolicies) {
            result = result.plus(each.calculateDiscountAmount(screening));
        }
        return result;
    }
}
