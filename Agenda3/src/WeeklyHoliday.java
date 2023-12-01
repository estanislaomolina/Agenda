import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyHoliday extends Holiday {
    private DayOfWeek dayOfWeek;
    public WeeklyHoliday(DayOfWeek dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }
    @Override
    public LocalDate getDate() {
        return LocalDate.now().with(dayOfWeek);
    }
}
