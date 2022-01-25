package domain.policy.addition;

import domain.Money;
import domain.Phone;

public interface FeePolicy {
    public Money getCalculateFee(Phone phone);
}
