import domain.Money;
import domain.Call;
import domain.Phone;
import domain.policy.addition.AmountDiscountPolicy;
import domain.policy.addition.TaxablePolicy;
import domain.policy.basic.DateTimeInterval;
import domain.policy.basic.TimeOfDayDiscountPolicy;
import domain.policy.basic.FixedFeePolicy;

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
        기본_정책_요금계산();
        심야_정책_요금계산();
        기본_정책_세금부가_요금계산();
        심야_정책_세금부가_요금계산();
        기본_정책_세금부가_금액할인_요금계산();
    }


    public static void 기본_정책_요금계산() {
        FixedFeePolicy regularPolicy = new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10));
        DateTimeInterval call1 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 13, 0),
                LocalDateTime.of(2022, 1, 20, 13, 5));
        DateTimeInterval call2 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 22, 0),
                LocalDateTime.of(2022, 1, 20, 22, 10));

        Phone phone = new Phone(regularPolicy, new Call(call1), new Call(call2));

        System.out.println("기본_정책_요금계산 = " + phone.getPhoneFee().amount);
    }

    public static void 심야_정책_요금계산() {
        /*TimeOfDayDiscountPolicy nightlyPolicy = new TimeOfDayDiscountPolicy(Money.wons(10), Money.wons(5), Duration.ofSeconds(10));

        DateTimeInterval call1 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 13, 0),
                LocalDateTime.of(2022, 1, 20, 13, 5));
        DateTimeInterval call2 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 22, 0),
                LocalDateTime.of(2022, 1, 20, 22, 10));

        Phone phone = new Phone(nightlyPolicy, new Call(call1), new Call(call2));

        System.out.println("심야_정책_요금계산 = " + phone.getPhoneFee().amount);*/
    }

    public static void 기본_정책_세금부가_요금계산() {
        FixedFeePolicy regularPolicy = new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10));
        TaxablePolicy taxablePolicy = new TaxablePolicy(regularPolicy, 0.2);

        DateTimeInterval call1 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 13, 0),
                LocalDateTime.of(2022, 1, 20, 13, 5));
        DateTimeInterval call2 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 22, 0),
                LocalDateTime.of(2022, 1, 20, 22, 10));

        Phone phone = new Phone(taxablePolicy, new Call(call1), new Call(call2));

        System.out.println("기본_정책_세금부가_요금계산 = " + phone.getPhoneFee().amount);
    }

    public static void 심야_정책_세금부가_요금계산() {
        /*TimeOfDayDiscountPolicy nightlyPolicy = new TimeOfDayDiscountPolicy(Money.wons(10), Money.wons(5), Duration.ofSeconds(10));
        TaxablePolicy taxablePolicy = new TaxablePolicy(nightlyPolicy, 0.2);

        DateTimeInterval call1 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 13, 0),
                LocalDateTime.of(2022, 1, 20, 13, 5));
        DateTimeInterval call2 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 22, 0),
                LocalDateTime.of(2022, 1, 20, 22, 10));

        Phone phone = new Phone(taxablePolicy, new Call(call1), new Call(call2));

        System.out.println("심야_정책_세금부가_요금계산 = " + phone.getPhoneFee().amount);*/
    }

    public static void 기본_정책_세금부가_금액할인_요금계산() {
        FixedFeePolicy regularPolicy = new FixedFeePolicy(Money.wons(10), Duration.ofSeconds(10));
        TaxablePolicy taxablePolicy = new TaxablePolicy(regularPolicy, 0.2);
        AmountDiscountPolicy amountDiscountPolicy = new AmountDiscountPolicy(taxablePolicy, Money.wons(500));

        DateTimeInterval call1 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 13, 0),
                LocalDateTime.of(2022, 1, 20, 13, 5));
        DateTimeInterval call2 = new DateTimeInterval(
                LocalDateTime.of(2022, 1, 20, 22, 0),
                LocalDateTime.of(2022, 1, 20, 22, 10));

        Phone phone = new Phone(amountDiscountPolicy, new Call(call1), new Call(call2));

        System.out.println("기본_정책_세금부가_금액할인_요금계산 = " + phone.getPhoneFee().amount);
    }


}
