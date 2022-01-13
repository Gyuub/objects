package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Screening {
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount),audienceCount);
    }

    public Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public boolean isSequence(int sequence){
        return this.sequence == sequence;
    }

    public LocalDateTime getStartTime() {
        return this.whenScreened;
    }
    public Money getMovieFee(){
        return movie.getFee();
    }
}
