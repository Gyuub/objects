package bad.domain;

import bad.domain.*;
import bad.domain.codition.DiscountCondition;
import bad.domain.policy.AmountDiscountPolicy;
import bad.domain.policy.DiscountPolicy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateDiscountedFee(Screening screening) {
        return discountPolicy.calculateDiscountedFee(screening);
    }




}
