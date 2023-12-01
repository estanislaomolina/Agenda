import java.time.LocalDate;

public class PeriodHoliday extends Holiday{
    private LocalDate startDate;
    private LocalDate endDate;
    public PeriodHoliday(LocalDate startDate, LocalDate localDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public LocalDate getDate() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(startDate)) {
            return startDate;
        } else if (today.isAfter(endDate)) {
            return null;
        } else {
            return today;
        }
    }
}

