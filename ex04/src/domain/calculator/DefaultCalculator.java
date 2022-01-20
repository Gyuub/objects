package domain.calculator;

import domain.Call;
import domain.Money;
import domain.Phone;

import java.time.Duration;

public abstract class DefaultCalculator{

    public Money getCalculateFee(Phone phone){
        Money result = Money.ZERO;
        for (Call each : phone.getCalls()) {
            result = result.plus(calculate(each));
        }
        return result;
    }

    protected abstract Money calculate(Call call);


}
