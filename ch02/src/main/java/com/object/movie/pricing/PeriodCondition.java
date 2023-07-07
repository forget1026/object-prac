package com.object.movie.pricing;

import com.object.movie.Screening;
import com.object.movie.pricing.DiscountCondition;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public PeriodCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek)
                // 개인적으로 되게 직관적이지 않음.. isBeforeEqual
                && !startTime.isAfter(screening.getStartTime().toLocalTime())
                && !endTime.isBefore(screening.getStartTime().toLocalTime());
    }
}
