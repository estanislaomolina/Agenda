import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PeriodHoliday extends Holiday{
    private LocalDate startDate;
    private LocalDate endDate;
    public PeriodHoliday(LocalDate startDate, LocalDate endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }
    @Override
    public LocalDate getDate() {
        LocalDate today = LocalDate.now();
        if (today.isAfter(startDate) && today.isBefore(endDate)) {
            return today;
        } else {
            return null;
        }
    }
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}

