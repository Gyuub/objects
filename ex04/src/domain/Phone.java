package domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phone {
    private Calculator calculator;
    private List<Call> calls = new ArrayList<>();

    public Phone(Calculator calculator, Call ...call) {
        this.calculator = calculator;
        this.calls = this.calls = Arrays.asList(call);
    }

    public Phone(Calculator calculator) {
        this.calculator = calculator;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void call(Call call){
        calls.add(call);
    }

    public double getPhoneFee(){
        return calculator.getFee(this);
    }

}
