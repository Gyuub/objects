package domain.policy.condition;

import domain.Call;
import domain.DateTimeInterval;

import java.util.List;

public class FixedFeeCondition implements FeeCondition {
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.splitByDay();
    }
}
