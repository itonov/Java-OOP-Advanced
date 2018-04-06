package weekdays;

import java.util.Set;
import java.util.TreeSet;

public class WeeklyCalendar {
    private Set<WeeklyEntry> entries;

    public WeeklyCalendar() {
        this.entries = new TreeSet<>();
    }

    public void addEntry(String weekday, String notes) {
        this.entries.add(new WeeklyEntry(weekday, notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule() {
        return this.entries;
    }
}
