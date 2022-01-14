package bad.domain;

public class Customer {
    private Money money;
    public Customer(Money money){
        this.money = money;
    }

    public void buy(Money fee) {
        this.money = money.minus(fee);
        System.out.println("영화표 구입 완료");
        System.out.println("남은 돈 => " + this.money.amount);
    }
}
