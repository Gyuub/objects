package domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {
    private DateTimeInterval dateTimeInterval;

    public Call(DateTimeInterval dateTimeInterval) {
        this.dateTimeInterval = dateTimeInterval;
    }

    public List<DateTimeInterval> splitByDay(){
        return dateTimeInterval.splitByDay();
    }
    public Duration getDuration() {
        return dateTimeInterval.getDuration();
    }

    public LocalDateTime getFrom() {
        return dateTimeInterval.getFrom();
    }
    public LocalDateTime getTo() {
        return dateTimeInterval.getTo();
    }
}
