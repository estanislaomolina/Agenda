import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class AgendaTests {

    @Test public void test00AgendaIsCreatedEmpty() {
        Agenda agenda = new Agenda();
        assertTrue(agenda.isEmpty());
    }
    @Test public void test01RegisterSpecififcHoliday() {
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addHoliday(specificHoliday);
        assertTrue(agenda.isHoliday(specificHoliday));
    }

    @Test public void test02SpecificHolidayNotFound() {
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addHoliday(specificHoliday);
        assertFalse(agenda.isHoliday(new SpecificHoliday(LocalDate.of(2021, 1, 2))));
    }
    @Test public void test03RegisterWeeklyHoliday() {
        Agenda agenda = new Agenda();
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(weeklyHoliday);
        assertTrue(agenda.isHoliday(weeklyHoliday));
    }

    @Test public void test04WeeklyHolidayNotFound() {
        Agenda agenda = new Agenda();
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(weeklyHoliday);
        assertFalse(agenda.isHoliday(new WeeklyHoliday(DayOfWeek.MONDAY)));
    }
    @Test public void test05RegisterPeriodHoliday() {
        Agenda agenda = new Agenda();
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.addHoliday(periodHoliday);
        assertTrue(agenda.isHoliday(periodHoliday));
    }
    @Test public void test06PeriodHolidayNotFound() {
        Agenda agenda = new Agenda();
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.addHoliday(periodHoliday);
        assertFalse(agenda.isHoliday(new PeriodHoliday(LocalDate.of(2021, 1, 4), LocalDate.of(2021, 1, 6))));
    }
    @Test public void test07RemoveSpecificHoliday() {
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addHoliday(specificHoliday);
        agenda.removeHoliday(specificHoliday);
        assertFalse(agenda.isHoliday(specificHoliday));
    }
    @Test public void test08RemoveWeeklyHoliday() {
        Agenda agenda = new Agenda();
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(weeklyHoliday);
        agenda.removeHoliday(weeklyHoliday);
        assertFalse(agenda.isHoliday(weeklyHoliday));
    }
    @Test public void test09RemovePeriodHoliday() {
        Agenda agenda = new Agenda();
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.addHoliday(periodHoliday);
        agenda.removeHoliday(periodHoliday);
        assertFalse(agenda.isHoliday(periodHoliday));
    }

    @Test public void test10AddDifferentHolidays() {
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));

        agenda.addHoliday(specificHoliday);
        agenda.addHoliday(weeklyHoliday);
        agenda.addHoliday(periodHoliday);

        assertTrue(agenda.isHoliday(specificHoliday));
        assertTrue(agenda.isHoliday(weeklyHoliday));
        assertTrue(agenda.isHoliday(periodHoliday));
    }
    @Test public void test11RemoveDifferentHolidays() {
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));

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
        Agenda agenda = new Agenda();
        SpecificHoliday specificHoliday = new SpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addHoliday(specificHoliday);
        agenda.addHoliday(specificHoliday);
    }
    @Test public void test13WeeklyHolidayAlreadyRegistered() {
        Agenda agenda = new Agenda();
        WeeklyHoliday weeklyHoliday = new WeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addHoliday(weeklyHoliday);
        agenda.addHoliday(weeklyHoliday);
    }
    @Test public void test14PeriodHolidayAlreadyRegistered() {
        Agenda agenda = new Agenda();
        PeriodHoliday periodHoliday = new PeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.addHoliday(periodHoliday);
        try {

            agenda.addHoliday(periodHoliday);
        } catch (IllegalArgumentException e) {
            assertEquals("Holiday already registered", e.getMessage());
        }
    }
}
