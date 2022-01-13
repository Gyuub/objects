package domain;

public class Customer {
    private Money money;
    private Reservation reservation;

    public Customer(Money money) {
        this(money, null);
    }

    public Customer(Money money, Reservation reservation) {
        this.money = money;
        this.reservation = reservation;
    }

    public void buy(Money fee){
        this.money = new Money(this.money.minus(fee).amount);

        System.out.println("영화표 구입 완료");
        System.out.println("남은 돈 => " + this.money.amount);
    }
}
