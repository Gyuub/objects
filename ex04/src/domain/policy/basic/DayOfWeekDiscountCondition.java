package domain.policy.basic;

import domain.Call;
import domain.DateTimeInterval;
import domain.Money;
import domain.policy.good.FeeCondition;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//월요일 ~ 금요일 10초당 38원
//토요일 ~ 일요일 19초당 19원
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
