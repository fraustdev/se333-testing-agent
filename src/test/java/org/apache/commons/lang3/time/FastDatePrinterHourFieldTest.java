package org.apache.commons.lang3.time;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class FastDatePrinterHourFieldTest {

    @Test
    public void testTwelveHourAtMidnight() {
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final Locale loc = Locale.US;
        final FastDatePrinter fp = new FastDatePrinter("h", tz, loc);
        final GregorianCalendar cal = new GregorianCalendar(tz, loc);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        assertEquals("12", fp.format(cal));
    }

    @Test
    public void testTwelveHourAfternoon() {
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final Locale loc = Locale.US;
        final FastDatePrinter fp = new FastDatePrinter("h", tz, loc);
        final GregorianCalendar cal = new GregorianCalendar(tz, loc);
        cal.set(Calendar.HOUR_OF_DAY, 13);
        assertEquals("1", fp.format(cal));
    }

    @Test
    public void testTwentyFourHourAtMidnight() {
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final Locale loc = Locale.US;
        final FastDatePrinter fp = new FastDatePrinter("k", tz, loc);
        final GregorianCalendar cal = new GregorianCalendar(tz, loc);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        assertEquals("24", fp.format(cal));
    }

    @Test
    public void testTwentyFourHourAfternoon() {
        final TimeZone tz = TimeZone.getTimeZone("UTC");
        final Locale loc = Locale.US;
        final FastDatePrinter fp = new FastDatePrinter("k", tz, loc);
        final GregorianCalendar cal = new GregorianCalendar(tz, loc);
        cal.set(Calendar.HOUR_OF_DAY, 13);
        assertEquals("13", fp.format(cal));
    }
}
