package com.object.movie.pricing;

import com.object.money.Money;
import com.object.movie.DiscountPolicy;
import com.object.movie.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
