package domain.policy.basic;

import domain.Call;
import domain.DateTimeInterval;
import domain.Money;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

//월요일 ~ 금요일 10초당 38원
//토요일 ~ 일요일 19초당 19원
public class DayOfWeekDiscountPolicy extends BascicPolicy{
    private List<DayOfWeekDiscountRule> weekDiscountRules = new ArrayList<>();


    public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> weekDiscountRules) {
        this.weekDiscountRules = weekDiscountRules;
    }

    @Override
    protected Money calculate(Call call) {
        Money result = Money.ZERO;
        for(DateTimeInterval interval : call.splitByDay()){
            for( DayOfWeekDiscountRule rule : weekDiscountRules){
                result.plus(rule.calculate(interval));
            }
        }
        return result;
    }
}
