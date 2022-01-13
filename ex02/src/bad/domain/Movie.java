package bad.domain;

import bad.domain.*;
import bad.domain.codition.DiscountCondition;
import bad.domain.policy.DiscountPolicy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private DiscountPolicy discountPolicy;
    private double discountPercent;

    public Money calculateDiscountedFee(Screening screening){
        if(isSatisfiedBy(screening)){
            return discountPolicy.calculateDiscountedFee(this);
        }
        return fee;
    }

    public boolean isSatisfiedBy(Screening screening){
        return discountConditions.stream()
                .anyMatch(codition -> codition.isDiscountable(screening));
    }

    public Money getFee() {
        return fee;
    }



}
