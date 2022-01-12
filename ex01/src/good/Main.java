package good;

import good.domain.*;

/**
 * 절차지향적 프로그래밍 방법에서
 * 객체지향적 프로그래밍으로 개선
 *
 * @author Hman
 * @version 1.0.0
 * 작성일 2022-01-11
 */
public class Main {
    public static void main(String[] args) {
        Audience 이벤트당첨자 = createAudience(new Invitation());
        Audience 당첨못된자 = createAudience();

        TicketOffice 티켓판매대 = new TicketOffice(0, new Ticket(), new Ticket());
        TicketSeller 티켓알바 = new TicketSeller(티켓판매대);
        Theater 소극장 = new Theater(티켓알바);

        소극장.enter(이벤트당첨자);
        소극장.enter(당첨못된자);


    }

    public static Audience createAudience(){
        return createAudience(null);
    }

    public static Audience createAudience(Invitation invitation){
        Bag bag = new Bag(1000, invitation);
        return new Audience(bag);
    }

}
