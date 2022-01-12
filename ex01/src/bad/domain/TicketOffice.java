package bad.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {
    private long amount;
    private List<bad.domain.Ticket> ticketList = new ArrayList<>();

    public TicketOffice(long amount, bad.domain.Ticket... ticketList) {
        this.amount = amount;
        this.ticketList.addAll(Arrays.asList(ticketList));
    }

    public Ticket getTicket() {
        return this.ticketList.remove(0);
    }

    public void plusAmount(long amount){
        this.amount += amount;
        System.out.println("매출액 = " + this.amount);
    }


}
