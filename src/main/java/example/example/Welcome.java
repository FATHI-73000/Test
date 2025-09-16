package example.example;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Welcome {

    private final IDateTimeProvider dateTimeProvider;

    public Welcome() {
        this.dateTimeProvider = new SystemDateTimeProvider();
    }

    public Welcome(IDateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    public String getMessage() {
        LocalDateTime now = dateTimeProvider.now();
        DayOfWeek day = now.getDayOfWeek();
        int hour = now.getHour();

        if (isWeekend(day, hour)) return "Bon week-end";
        else if (hour >= 9 && hour < 13) return "Bonjour";
        else if (hour >= 13 && hour < 18) return "Bon après-midi";
        else return "Bonsoir";
    }

    private boolean isWeekend(DayOfWeek day, int hour) {
        return (day == DayOfWeek.FRIDAY && hour >= 18) ||
                (day == DayOfWeek.SATURDAY) ||
                (day == DayOfWeek.SUNDAY) ||
                (day == DayOfWeek.MONDAY && hour < 9);
    }
}
