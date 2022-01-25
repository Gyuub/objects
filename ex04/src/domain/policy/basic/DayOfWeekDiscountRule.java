package domain.policy.basic;

import domain.DateTimeInterval;
import domain.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DayOfWeekDiscountRule {
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();
    private Money amount = Money.ZERO;
    private Duration duration = Duration.ZERO;

    public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Money amount, Duration duration) {
        this.dayOfWeeks = dayOfWeeks;
        this.amount = amount;
        this.duration = duration;
    }

    public Money calculate(DateTimeInterval interval){
        if (dayOfWeeks.contains(interval.getTo().getDayOfWeek())){
            return amount.times(interval.getDuration().getSeconds()/ duration.getSeconds());
        }
        return Money.ZERO;
    }

    public List<DayOfWeek> getDayOfWeeks() {
        return dayOfWeeks;
    }
}
