package domain.policy.basic;

import domain.Call;
import domain.DateTimeInterval;
import domain.Money;
import domain.policy.good.FeeCondition;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeOfDayDiscountCondition implements FeeCondition {

    private LocalTime from;
    private LocalTime to;

    public TimeOfDayDiscountCondition(LocalTime from, LocalTime to) {
        this.from = from;
        this.to = to;
    }

    private LocalTime from(DateTimeInterval interval) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from :
                interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval) {
        return interval.getTo().toLocalTime().isAfter(to) ?
                to :
                interval.getTo().toLocalTime();
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.splitByDay()
                .stream()
                .filter(o -> from(o).isBefore(from))
                .map(o -> DateTimeInterval.of(
                        LocalDateTime.of(o.getFrom().toLocalDate(), from(o)),
                        LocalDateTime.of(o.getTo().toLocalDate(), to(o))))
                .collect(Collectors.toList());
    }
}
