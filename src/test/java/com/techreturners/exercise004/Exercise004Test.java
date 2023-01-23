package com.techreturners.exercise004;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercise004Test {

    @Test
    public void checkGetDateTimeWhenDateIsSpecified() {

        Exercise004 ex004 = new Exercise004(LocalDate.of(2021, Month.JULY, 19));
        LocalDateTime expected = LocalDateTime.of(2053, Month.MARCH, 27, 1, 46, 40);

        assertEquals(expected, ex004.getDateTime());
    }

    @Test
    public void checkGetDateTimeWhenBothDateAndTimeIsSpecified() {

        Exercise004 ex004 = new Exercise004(LocalDateTime.of(2021, Month.MARCH, 4, 23, 22, 0, 0));
        LocalDateTime expected = LocalDateTime.of(2052, Month.NOVEMBER, 11, 1, 8, 40);

        assertEquals(expected, ex004.getDateTime());
    }

    @Test
    public void checkGetDateTimeWhenBothDateAndTimeIsSpecifiedWithDayRollOver() {

        Exercise004 ex004 = new Exercise004(LocalDateTime.of(2021, Month.JANUARY, 24, 23, 59, 59, 0));
        LocalDateTime expected = LocalDateTime.of(2052, Month.OCTOBER, 3, 1, 46, 39);

        assertEquals(expected, ex004.getDateTime());
    }

    // Additional tests below:

    @Test
    public void checkGetDateTimeGigasecondFromNow() {

        // Must be instantiated, as referencing LocalDateTime.now() twice separately will produce different times as
        // each is called.
        LocalDateTime now = LocalDateTime.now();

        Exercise004 ex004 = new Exercise004(now);
        LocalDateTime expected = now.plus(Duration.of((long) Math.pow(10,9), ChronoUnit.SECONDS));

        assertEquals(expected, ex004.getDateTime());

    }

    @Test
    public void checkGetDateTimeTwiceWhenDateIsSpecified() {

        LocalDate initialDate = LocalDate.of(2022, Month.FEBRUARY, 2);

        Exercise004 ex004 = new Exercise004(new Exercise004(initialDate).getDateTime());
        LocalDateTime expected = initialDate.atStartOfDay().plus(Duration.of((long) (2*(Math.pow(10,9))), ChronoUnit.SECONDS));

        assertEquals(expected, ex004.getDateTime());

    }

    @Test
    public void checkGetDateTimeTwiceWhenBothDateAndTimeIsSpecified() {

        LocalDateTime initialDateTime = LocalDateTime.of(2022, Month.FEBRUARY, 2, 2, 2, 22);

        Exercise004 ex004 = new Exercise004(new Exercise004(initialDateTime).getDateTime());
        LocalDateTime expected = initialDateTime.plus(Duration.of((long) (2*(Math.pow(10,9))), ChronoUnit.SECONDS));

        assertEquals(expected, ex004.getDateTime());

    }

    @Test
    public void checkGetDateTimeFromMax() {

        // It may seem more intuitive to have this throw when calling the .getDateTime() method on the object, but given
        // that the object's entire purpose is to add a gigasecond to its constructor's argument it would make more
        // sense for the error to be caught on initialisation.

        assertThrows(InvalidDateTimeException.class, () -> new Exercise004(LocalDateTime.MAX));

    }

}
