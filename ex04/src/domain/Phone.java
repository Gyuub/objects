package domain;

import domain.policy.basic.BascicPolicy;

import java.util.ArrayList;
import java.util.List;

public class Phone {
    private BascicPolicy calculator;
    private List<Call> calls = new ArrayList<>();

    public Phone(BascicPolicy calculator) {
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
