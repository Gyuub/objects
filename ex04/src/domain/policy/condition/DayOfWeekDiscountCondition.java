package domain.policy.condition;

import domain.Call;
import domain.DateTimeInterval;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class DayOfWeekDiscountCondition implements FeeCondition {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();

    public DayOfWeekDiscountCondition(List<DayOfWeek> dayOfWeeks) {
        this.dayOfWeeks = dayOfWeeks;
    }

    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return call.splitByDay()
                .stream()
                .filter(o -> dayOfWeeks.contains(o.getFrom().getDayOfWeek()))
                .collect(Collectors.toList());
    }
}
