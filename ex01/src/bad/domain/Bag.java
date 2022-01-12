package bad.domain;

public class Bag {
    private long amount;
    Ticket ticket;
    Invitation invitation;

    public Bag(long amount) {
        this(amount, null);
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }



    public boolean hasInvitation() {
        return this.invitation != null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }


}
