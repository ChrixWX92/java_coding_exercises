package com.techreturners.exercise004;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Exercise004 {

    // The java.time.temporal package was born to deal with this exercise!

    private final Duration gigasecond = Duration.of((long) Math.pow(10,9), ChronoUnit.SECONDS);

    private LocalDateTime dateTime;

    public Exercise004(LocalDate date) {
        // If no time is specified, we can only assume to start at 00:00:00 of the date given.
        this.checkAdditionPossible(date.atStartOfDay());
    }

    public Exercise004(LocalDateTime dateTime) {
        this.checkAdditionPossible(dateTime);
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    private void checkAdditionPossible(LocalDateTime localDateTime) {

        if (localDateTime.isAfter(LocalDateTime.MAX.minus(gigasecond)))
            throw new InvalidDateTimeException("To add a gigasecond to " + localDateTime + " would produce an invalid date/time.");

        this.dateTime = localDateTime.plus(gigasecond);

    }

}
