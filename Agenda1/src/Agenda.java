import java.time.DayOfWeek;
import java.util.ArrayList;
import java.time.LocalDate;

public class Agenda {
    // create an array list that works as it stores holidays
    public ArrayList<LocalDate> holidays = new ArrayList<>();
    public ArrayList <DayOfWeek> holidays2 = new ArrayList<>();
    public Agenda(){
        this.holidays = holidays;
    }
    // create a method that adds holidays to the array list
    public void addSpecificHoliday(LocalDate holiday){
        holidays.add(holiday);
    }
    public void addWeeklyHoliday(DayOfWeek holiday){
        holidays2.add(holiday);
    }
    public void addPeriodHoliday(LocalDate startDate, LocalDate endDate){
        LocalDate date = startDate;
        while (!date.isAfter(endDate)){
            holidays.add(date);
            date = date.plusDays(1);
        }
    }
    // create a method that removes holidays from the array list
    public void removeSpecificHoliday(LocalDate holiday){
        holidays.remove(holiday);
    }
    // create a method that checks if a holiday is in the array list
    public boolean isSpecificHoliday(LocalDate holiday){
        return holidays.contains(holiday);
    }

    public boolean isEmpty() {
        return holidays.isEmpty();
    }

    public boolean isWeeklyHoliday(DayOfWeek holiday) {
        return holidays2.contains(holiday);
    }
    public boolean isPeriodHoliday(LocalDate holiday){
        return holidays.contains(holiday);
    }

    public void removeWeeklyHoliday(DayOfWeek holiday) {
        holidays2.remove(holiday);
    }
    public void removePeriodHoliday(LocalDate startDate, LocalDate endDate){
        LocalDate date = startDate;
        while (!date.isAfter(endDate)){
            holidays.remove(date);
            date = date.plusDays(1);
        }
    }
    public void cannotAddHolidayThatisAlreadyRegistered(LocalDate holiday){
        if (holidays.contains(holiday)){
            throw new IllegalArgumentException("Holiday already registered");
        }
    }
}

// create a method that prints the holidays
// create a method that checks if two array lists are equal
// create a method that checks if two array lists have common elements
// create a method that returns the number of holidays in the array list
// create a method that returns the number of holidays in a given interval
// create a method that returns the number of holidays in a given interval
// create a method that returns the number of holidays in a given interval
