package ObjectMovie;

import ObjectMovie.discount.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {

        Movie movie = new Movie("아바타2", Duration.ofMinutes(120), Money.wons(10000),
                (DiscountPolicy) new AmountDiscountPolicy(Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10),
                    new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10,0), LocalTime.of(11,59 )),
                    new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));

        Movie titanic = new Movie("타이타닉2", Duration.ofMinutes(180), Money.wons(11000),
                (DiscountPolicy) new PercentDiscountPolicy(0.1,
                            new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                            new SequenceCondition(2),
                            new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));

        Movie starWars = new Movie("스타워즈2", Duration.ofMinutes(150), Money.wons(10000),
                new NoneDiscountPolicy());

    }
}
