package domain;

import domain.policy.FeePolicy;
import domain.policy.addition.TaxablePolicy;
import domain.policy.basic.BascicPolicy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Phone {
    private FeePolicy policy;
    private List<Call> calls = new ArrayList<>();

    public Phone(FeePolicy policy) {
        this.policy = policy;
    }

    public Phone(FeePolicy policy, Call  ...call) {
        this.policy = policy;
        this.calls = Arrays.asList(call);
    }


    public List<Call> getCalls() {
        return calls;
    }

    public void call(Call call){
        calls.add(call);
    }

    public Money getPhoneFee(){
        return policy.getCalculateFee(this);
    }

}
