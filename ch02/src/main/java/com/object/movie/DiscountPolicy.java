package com.object.movie;

import com.object.money.Money;
import com.object.movie.pricing.DiscountCondition;

import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private final List<DiscountCondition> conditions;

    public DiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    protected abstract Money getDiscountAmount(Screening screening);

}
