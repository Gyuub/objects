package bad.domain;

import bad.domain.*;

public class ReservationAgency {
    public Reservation reserve(Customer customer, Screening screening, int audienceCount) {
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
