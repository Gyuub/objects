package good.domain;



import good.domain.policy.DiscountPolicy;
import good.domain.policy.PercentDiscountPolicy;

import java.time.Duration;

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
        return discountPolicy.calculateDiscountAmount(screening);
    }

    public void changeDiscountPolicy(PercentDiscountPolicy percentDiscountPolicy) {
        this.discountPolicy = percentDiscountPolicy;
    }
}
