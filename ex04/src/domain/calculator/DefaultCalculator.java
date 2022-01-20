package domain.calculator;

import domain.Call;
import domain.Money;
import domain.Phone;

import java.time.Duration;

public abstract class DefaultCalculator{
    protected Duration secound;
    protected Money amount;

    public DefaultCalculator() {
    }

    public DefaultCalculator(Duration secound, Money amount) {
        this.secound = secound;
        this.amount = amount;
    }

    public Money getCalculateFee(Phone phone){
        Money result = Money.ZERO;
        for (Call each : phone.getCalls()) {
            result = result.plus(calculate(each));
        }
        return result;
    }

    protected abstract boolean isSatisfiedBy(Call call);
    protected abstract Money calculate(Call call);


}
