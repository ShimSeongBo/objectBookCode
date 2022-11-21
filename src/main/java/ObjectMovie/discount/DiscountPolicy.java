package ObjectMovie.discount;

import ObjectMovie.Money;
import ObjectMovie.Screening;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
