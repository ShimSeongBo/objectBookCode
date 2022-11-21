package ObjectMovie.discount;

import ObjectMovie.Screening;

public interface DiscountConditionInterface {
    boolean isSatisfiedBy(Screening screening);
}
