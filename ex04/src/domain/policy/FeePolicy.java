package domain.policy;

import domain.Money;
import domain.Phone;

public interface FeePolicy {
    public Money getCalculateFee(Phone phone);
}
