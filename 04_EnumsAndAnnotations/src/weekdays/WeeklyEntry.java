package weekdays;

public class WeeklyEntry implements Comparable<WeeklyEntry> {
    private Weekday weekday;
    private String notes;

    public WeeklyEntry(String weekday, String notes) {
        this.weekday = Enum.valueOf(Weekday.class, weekday.toUpperCase());
        this.notes = notes;
    }

    @Override
    public String toString() {
        return this.weekday + " - " + this.notes;
    }

    @Override
    public int compareTo(WeeklyEntry o) {
        return this.weekday.compareTo(o.weekday);
    }
}
