import java.time.LocalDate;

public class SpecificHoliday extends Holiday {
    private LocalDate date;
    public SpecificHoliday(LocalDate date){
        this.date = date;
    }
    @Override
    public LocalDate getDate() {
        return date;
    }
}
