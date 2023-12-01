import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.function.Executable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.junit.Assert.*;


public class AgendaTests {
    private Agenda agenda;
    private SpecificHoliday specificHoliday;
    private WeeklyHoliday weeklyHoliday;
    private PeriodHoliday periodHoliday;

    private static final LocalDate june12023 = LocalDate.of(2023, 6, 1);
    private static final LocalDate june22023 = LocalDate.of(2023, 6, 2);
    private static final LocalDate june242023 = LocalDate.of(2023, 6, 24);
    private static final DayOfWeek sunday = DayOfWeek.SUNDAY;
    private static final DayOfWeek monday = DayOfWeek.MONDAY;
    private static final LocalDate startDateSummer2023 = LocalDate.of(2023, 6, 21);
    private static final LocalDate endDateSummer2023 = LocalDate.of(2023, 9, 22);
    private static final LocalDate startDateWinter2023 = LocalDate.of(2023, 12, 21);
    private static final LocalDate endDateWinter2023 = LocalDate.of(2024, 3, 20);
    private static final String holidayAlreadyRegisteredError = "Holiday already registered";
    private static final String holidayNotRegisteredError = "Holiday not registered";

    @Before
    public void setUp() {
        agenda = new Agenda();
        specificHoliday = new SpecificHoliday(june12023);
        weeklyHoliday = new WeeklyHoliday(sunday);
        periodHoliday = new PeriodHoliday(startDateSummer2023, endDateSummer2023);

    }

    @Test public void test00AgendaIsCreatedEmpty() {
        assertTrue(agenda.isEmpty());
    }
    @Test public void test01RegisterSpecififcHoliday() {
        agenda.addHoliday(specificHoliday);
        assertTrue(agenda.isHoliday(specificHoliday));
    }

    @Test public void test02SpecificHolidayNotFound() {
        agenda.addHoliday(specificHoliday);
        assertFalse(agenda.isHoliday(new SpecificHoliday(june22023)));
    }
    @Test public void test03RegisterWeeklyHoliday() {
        agenda.addHoliday(weeklyHoliday);
        assertTrue(agenda.isHoliday(weeklyHoliday));
    }

    @Test public void test04WeeklyHolidayNotFound() {
        agenda.addHoliday(weeklyHoliday);
        assertFalse(agenda.isHoliday(new WeeklyHoliday(monday)));
    }
    @Test public void test05RegisterPeriodHoliday() {
        agenda.addHoliday(periodHoliday);
        assertTrue(agenda.isHoliday(periodHoliday));
    }
    @Test public void test06PeriodHolidayNotFound() {
        agenda.addHoliday(periodHoliday);
        assertFalse(agenda.isHoliday(new PeriodHoliday(startDateWinter2023, endDateWinter2023)));
    }
    @Test public void test07RemoveSpecificHoliday() {
        agenda.addHoliday(specificHoliday);
        agenda.removeHoliday(specificHoliday);
        assertFalse(agenda.isHoliday(specificHoliday));
    }
    @Test public void test08RemoveWeeklyHoliday() {
        agenda.addHoliday(weeklyHoliday);
        agenda.removeHoliday(weeklyHoliday);
        assertFalse(agenda.isHoliday(weeklyHoliday));
    }
    @Test public void test09RemovePeriodHoliday() {
        agenda.addHoliday(periodHoliday);
        agenda.removeHoliday(periodHoliday);
        assertFalse(agenda.isHoliday(periodHoliday));
    }

    @Test public void test10AddDifferentHolidays() {
        agenda.addHoliday(specificHoliday);
        agenda.addHoliday(weeklyHoliday);
        agenda.addHoliday(periodHoliday);

        assertTrue(agenda.isHoliday(specificHoliday));
        assertTrue(agenda.isHoliday(weeklyHoliday));
        assertTrue(agenda.isHoliday(periodHoliday));
    }
    @Test public void test11RemoveDifferentHolidays() {
        agenda.addHoliday(specificHoliday);
        agenda.addHoliday(weeklyHoliday);
        agenda.addHoliday(periodHoliday);

        agenda.removeHoliday(specificHoliday);
        agenda.removeHoliday(weeklyHoliday);
        agenda.removeHoliday(periodHoliday);

        assertFalse(agenda.isHoliday(specificHoliday));
        assertFalse(agenda.isHoliday(weeklyHoliday));
        assertFalse(agenda.isHoliday(periodHoliday));
    }
    @Test public void test12SpecificHolidayAlreadyRegistered() {
        agenda.addHoliday(specificHoliday);
        assertThrowsLike(() -> agenda.addHoliday(specificHoliday), holidayAlreadyRegisteredError);
    }
    @Test public void test13WeeklyHolidayAlreadyRegistered() {
        agenda.addHoliday(weeklyHoliday);
        assertThrowsLike(()-> agenda.addHoliday(weeklyHoliday), holidayAlreadyRegisteredError);
    }
    @Test public void test14PeriodHolidayAlreadyRegistered() {
        agenda.addHoliday(periodHoliday);
        assertThrowsLike(() -> agenda.addHoliday(periodHoliday), holidayAlreadyRegisteredError);
    }
    @Test public void test15CannotRemoveWeeklyHolidayNotRegistered() {
        assertThrowsLike(() -> agenda.removeHoliday(specificHoliday), holidayNotRegisteredError);
    }
    @Test public void test16CannotRemoveSpecificHolidayNotRegistered() {
        assertThrowsLike(() -> agenda.removeHoliday(weeklyHoliday), holidayNotRegisteredError);
    }
    @Test public void test17CannotRemovePeriodHolidayNotRegistered() {
        assertThrowsLike(() -> agenda.removeHoliday(periodHoliday), holidayNotRegisteredError);
    }
    @Test public void test18SpecificDayInPeriodHolidayIsHoliday() {
        agenda.addHoliday(periodHoliday);
        assertTrue(agenda.isDateInHoliday(new SpecificHoliday(june242023)));
        }
    private void assertThrowsLike(Executable executable, String expectedMessage){
        assertEquals (expectedMessage, assertThrows(IllegalArgumentException.class, executable).getMessage());
    }
}
