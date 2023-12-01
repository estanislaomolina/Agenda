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
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        assertTrue(agenda.isSpecificHoliday(LocalDate.of(2021, 1, 1)));
    }
    @Test public void test02SpecificHolidayNotFound() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        assertFalse(agenda.isSpecificHoliday(LocalDate.of(2021, 1, 2)));
    }
    @Test public void test03RegisterWeeklyHoliday() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertTrue(agenda.isWeeklyHoliday(DayOfWeek.SUNDAY));
    }
    @Test public void test04WeeklyHolidayNotFound() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        assertFalse(agenda.isWeeklyHoliday(DayOfWeek.MONDAY));
    }
    @Test public void test05RegisterPeriodHoliday() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 1)));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 2)));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 3)));
    }
    @Test public void test06PeriodHolidayNotFound() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 4)));
    }
    @Test public void test07RemoveSpecificHoliday() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.removeSpecificHoliday(LocalDate.of(2021, 1, 1));
        assertFalse(agenda.isSpecificHoliday(LocalDate.of(2021, 1, 1)));
    }
    @Test public void test08RemoveWeeklyHoliday() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.removeWeeklyHoliday(DayOfWeek.SUNDAY);
        assertFalse(agenda.isWeeklyHoliday(DayOfWeek.SUNDAY));
    }
    @Test public void test09RemovePeriodHoliday() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.removePeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 1)));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 2)));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 3)));
    }

    @Test public void test10AddDifferentHolidays() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        assertTrue(agenda.isSpecificHoliday(LocalDate.of(2021, 1, 1)));
        assertTrue(agenda.isWeeklyHoliday(DayOfWeek.SUNDAY));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 1)));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 2)));
        assertTrue(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 3)));
    }
    @Test public void test11RemoveDifferentHolidays() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        agenda.removeSpecificHoliday(LocalDate.of(2021, 1, 1));
        agenda.removeWeeklyHoliday(DayOfWeek.SUNDAY);
        agenda.removePeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        assertFalse(agenda.isSpecificHoliday(LocalDate.of(2021, 1, 1)));
        assertFalse(agenda.isWeeklyHoliday(DayOfWeek.SUNDAY));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 1)));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 2)));
        assertFalse(agenda.isPeriodHoliday(LocalDate.of(2021, 1, 3)));
    }
    @Test public void test12SpecificHolidayAlreadyRegistered() {
        Agenda agenda = new Agenda();
        agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        try {
            agenda.addSpecificHoliday(LocalDate.of(2021, 1, 1));
        } catch (IllegalArgumentException e) {
            assertEquals("Holiday already registered", e.getMessage());
        }
    }
    @Test public void test13WeeklyHolidayAlreadyRegistered() {
        Agenda agenda = new Agenda();
        agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        try {
            agenda.addWeeklyHoliday(DayOfWeek.SUNDAY);
        } catch (IllegalArgumentException e) {
            assertEquals("Holiday already registered", e.getMessage());
        }
    }
    @Test public void test14PeriodHolidayAlreadyRegistered() {
        Agenda agenda = new Agenda();
        agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        try {
            agenda.addPeriodHoliday(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 3));
        } catch (IllegalArgumentException e) {
            assertEquals("Holiday already registered", e.getMessage());
        }
    }
}
