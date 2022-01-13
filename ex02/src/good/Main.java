package good;

import good.domain.*;
import good.domain.condtion.PeriodCondtion;
import good.domain.condtion.SequenceCondition;
import good.domain.policy.AmountDiscountPolicy;
import good.domain.policy.NoneDiscountPolicy;
import good.domain.policy.PercentDiscountPolicy;

import java.time.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Customer 굽인이 = new Customer(Money.wons(30000));

        List<Movie> 영화리스트 = defaultMovie();
        Screening 상영영화 = new Screening(영화리스트.get(0),
                1,
                LocalDateTime.of(2022,1,13,12,00));

        //예매권
        Reservation 예매권 = 상영영화.reserve(굽인이, 1);

        //예매권 구입확정
        굽인이.buy(예매권.getFee());

    }

    public static List<Movie> defaultMovie(){
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(110),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondtion(DayOfWeek.MONDAY,
                                LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondtion(DayOfWeek.THURSDAY,
                                LocalTime.of(10, 0), LocalTime.of(20, 59))));
        avatar.changeDiscountPolicy(new PercentDiscountPolicy(0.2d));

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(90),
                Money.wons(11000),
                new PercentDiscountPolicy(0.1d,
                        new SequenceCondition(2),
                        new PeriodCondtion(DayOfWeek.MONDAY,
                                LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new PeriodCondtion(DayOfWeek.THURSDAY,
                                LocalTime.of(10, 0), LocalTime.of(13, 59))));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(100),
                Money.wons(10000),
                new NoneDiscountPolicy());

        return Arrays.asList(avatar, titanic, starWars);
    }
}
