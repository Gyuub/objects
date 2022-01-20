package domain;

import domain.calculator.DefaultCalculator;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private DefaultCalculator calculator;
    private List<Call> calls = new ArrayList<>();

    public Phone(DefaultCalculator calculator) {
        this.calculator = calculator;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void call(Call call){
        calls.add(call);
    }

    public Money getPhoneFee(){
        return calculator.getCalculateFee(this);
    }

}
