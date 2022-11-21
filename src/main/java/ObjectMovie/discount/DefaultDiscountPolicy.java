package ObjectMovie.discount;

import ObjectMovie.Money;
import ObjectMovie.Screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy {
    private List<DiscountConditionInterface> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountConditionInterface... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountConditionInterface each : conditions) {
            if (each.isSatisfiedBy(screening)) {
            return getDiscountAmount(screening);
            }
        }
    return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);

}