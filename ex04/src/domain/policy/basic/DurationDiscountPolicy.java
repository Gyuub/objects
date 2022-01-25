package domain.policy.basic;

import domain.Call;
import domain.Money;

public class DurationDiscountPolicy extends BascicPolicy{
    @Override
    protected Money calculate(Call call) {
        return null;
    }

    //00 ~ 18시 => 18원
    //19 ~ 24시 => 15원
    //2시간 동안 통화 했다면, 18 ~ 20시 => 18 ~ 19시 -> 18원 , 19 ~ 20시 -> 15원

    public void test(){
        
    }

}
