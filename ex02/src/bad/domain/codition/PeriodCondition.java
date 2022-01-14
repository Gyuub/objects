package bad.domain.codition;

import bad.domain.Movie;
import bad.domain.Screening;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition{

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isDiscountable(Screening screening) {
        return screening.getWhenScreened().getDayOfWeek().equals(dayOfWeek) &&
                this.startTime.compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                this.endTime.compareTo(screening.getWhenScreened().toLocalTime()) > 0 ;
    }
}
