import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {

    public ArrayList<Holiday> holidays = new ArrayList<>();
    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
    }

    public boolean isHoliday(Holiday holiday) {
        return holidays.contains(holiday);
    }

    public boolean isEmpty() {
        return holidays.isEmpty();
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
