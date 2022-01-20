package domain;

import java.time.Duration;
import java.time.LocalDateTime;

public class Call {
    private LocalDateTime statTime;
    private LocalDateTime endTime;

    public Call(LocalDateTime statTime, LocalDateTime endTime) {
        this.statTime = statTime;
        this.endTime = endTime;
    }

    public Duration getDuration(){
        return Duration.between(statTime, endTime);
    }

}
