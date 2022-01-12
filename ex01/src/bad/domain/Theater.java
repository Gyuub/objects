package bad.domain;

public class Theater {
    TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        if (audience.getBag().hasInvitation()) {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().minusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
