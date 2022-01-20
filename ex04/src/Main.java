import domain.Money;
import domain.Call;
import domain.Phone;
import domain.calculator.NightlyCalculator;
import domain.calculator.RegularCalculator;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 전화 요금 계산기
 *
 * <pre>
 * 가입자별로 통화 시간을 단위 시간당 요금으로 나눠준다.
 * 10초당 5원의 통화료를 부과한다
 * 100초 동안 통화를 했으면 100/10*5 = 50원 부과
 *
 * </pre>
 *
 * @author Hman
 * @version 1.0.0
 * 작성일 2022-01-20
 */
public class Main {
    public static void main(String[] args) {


        RegularCalculator calculator1 = new RegularCalculator(Money.wons(10), Duration.ofSeconds(10));
        NightlyCalculator calculator2 = new NightlyCalculator(Money.wons(10), Money.wons(5), Duration.ofSeconds(10));

        Call call1 = new Call(
                LocalDateTime.of(2022,1,20,13,0),
                LocalDateTime.of(2022,1,20,13,5)
                );
        Call call2 = new Call(
                LocalDateTime.of(2022,1,20,22,0),
                LocalDateTime.of(2022,1,20,22,10)
        );


        Phone phone = new Phone(calculator2);
        phone.call(call1);
        phone.call(call2);


        System.out.println("phone.getPhoneFee() = " + phone.getPhoneFee().amount);
    }
}
