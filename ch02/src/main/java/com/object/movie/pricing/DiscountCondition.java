package com.object.movie.pricing;

import com.object.movie.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
