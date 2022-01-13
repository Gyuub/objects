package good.domain;

import java.math.BigDecimal;

public class Money {
    public static final Money ZERO = Money.wons(0);
    public final BigDecimal amount;


    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }
    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }
    //==생성자메소드==//
    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    //==계산관련 메소드==//
    public Money plus(Money money){
        return new Money(this.amount.add(money.amount));
    }
    public Money minus(Money money){
        return new Money(this.amount.subtract(money.amount));
    }
    public Money times(double percent){
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThen(Money money){
        return this.amount.compareTo(money.amount) < 0;
    }
    public boolean isGreaterThenOrEqual(Money money){
        return this.amount.compareTo(money.amount) >= 0;
    }

}
