package domain;

public class Bag {
    private Invitation invitation;
    private long amount;
    private Ticket ticket;


    public Bag(long amount){
        this(amount, null);
        this.amount = amount;
    }
    public Bag(long amount, Invitation invitation){
        this.amount = amount;
        this.invitation = invitation;
    }

    public Long hold(Ticket ticket){
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L;
        } else {
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee();
        }
    }



    private boolean hasInvitation(){
        return this.invitation != null;
    }
    private boolean hasTicket(){
        return this.ticket != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void plusAmount(Long amount){
        this.amount += amount;
    }
    private void minusAmount(Long amount){
        this.amount -= amount;
    }


}
