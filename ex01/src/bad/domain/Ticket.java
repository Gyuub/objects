package bad.domain;

public class Ticket {
    private long fee;

    public Ticket() {
        this.fee = 1000L;
    }

    public long getFee() {
        return fee;
    }
}
