package domain.policy.condition;

import domain.Call;
import domain.DateTimeInterval;

import java.time.Duration;
import java.util.*;

public class DurationDiscountCondition implements FeeCondition {

    private Duration from;
    private Duration to;


    public DurationDiscountCondition(Duration from, Duration to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        if( call.getDuration().compareTo(from) < 0){
            return Collections.emptyList();
        }
        return Arrays.asList(
                DateTimeInterval.of(
                        call.getFrom().plus(from),
                        call.getDuration().compareTo(to) >0 ?
                                call.getFrom().plus(to) :
                                call.getTo()
                )
        );
    }
}
