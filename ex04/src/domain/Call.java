package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime statTime, LocalDateTime endTime) {
        this.from = statTime;
        this.to = endTime;
    }

    public Duration getDuration(){
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
