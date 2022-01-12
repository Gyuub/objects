package good.domain;

public class Ticket {
    private Long fee;

    public Ticket(){
        this.fee = 1000L;
    }

    public Long getFee() {
        return fee;
    }
}
