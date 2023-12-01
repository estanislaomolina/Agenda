import java.time.LocalDate;
import java.util.ArrayList;

public class Agenda {

    public ArrayList<Holiday> holidays = new ArrayList<>();
    public void addHoliday(Holiday holiday) {
        holidays.stream().filter(h -> h.equals(holiday)).forEach(h -> {
            throw new IllegalArgumentException("Holiday already registered");
        });
            holidays.add(holiday);
        }

    public void removeHoliday(Holiday holiday) {
        holidays.stream()
                .filter(h -> h.equals(holiday))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Holiday not registered"));
            holidays.remove(holiday);
        }
//        if (!holidays.contains(holiday)) {
//            throw new IllegalArgumentException("Holiday not registered");
//        }
//        else {
//            holidays.remove(holiday);

    public boolean isHoliday(Holiday holiday) {
        return holidays.stream().anyMatch(h -> h.equals(holiday));
    }
    public boolean isDateInHoliday(SpecificHoliday specificHoliday) {
        LocalDate date = specificHoliday.getDate(); // Assuming getDate() returns the LocalDate attribute
        return holidays.stream()
                .filter(holiday -> holiday instanceof PeriodHoliday)
                .map(holiday -> (PeriodHoliday) holiday)
                .anyMatch(holiday -> date.isAfter(holiday.getStartDate()) && date.isBefore(holiday.getEndDate()));
    }


    public boolean isEmpty() {
        return holidays.isEmpty();
    }
}
