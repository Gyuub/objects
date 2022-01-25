package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class TimeOfDayDiscountPolicy extends BascicPolicy {
    private List<LocalTime> starts = new ArrayList<>();
    private List<LocalTime> ends = new ArrayList<>();
    private List<Duration> durations = new ArrayList<>();
    private List<Money> amounts = new ArrayList<>();

    public TimeOfDayDiscountPolicy(List<LocalTime> starts, List<LocalTime> ends,
                                   List<Duration> durations, List<Money> amounts) {
        this.starts = starts;
        this.ends = ends;
        this.durations = durations;
        this.amounts = amounts;
    }

    @Override
    protected Money calculate(Call call) {
        Money result = Money.ZERO;
        for (DateTimeInterval interval : call.splitByDay()) {
            for (int i = 0; i < starts.size(); i++) {
                Money fee = amounts.get(i).times(
                        Duration.between(from(interval, starts.get(i)), to(interval, ends.get(i)))
                                .getSeconds() / durations.get(i).getSeconds()
                );
                result.plus(fee);
            }
        }

        return result;
    }

    private LocalTime from(DateTimeInterval interval, LocalTime from) {
        return interval.getFrom().toLocalTime().isBefore(from) ?
                from :
                interval.getFrom().toLocalTime();
    }

    private LocalTime to(DateTimeInterval interval, LocalTime to) {
        return interval.getTo().toLocalTime().isAfter(to) ?
                to :
                interval.getTo().toLocalTime();
    }

}
