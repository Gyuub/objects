package domain.policy.basic;

import domain.Call;
import domain.Money;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

//월요일 ~ 금요일 10초당 38원
//토요일 ~ 일요일 19초당 19원
public class DayOfWeekDiscountPolicy extends BascicPolicy{
    private List<DayOfWeek> dayOfWeeks = new ArrayList<>();


    @Override
    protected Money calculate(Call call) {
        return null;
    }
}
