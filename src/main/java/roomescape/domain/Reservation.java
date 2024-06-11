package roomescape.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public final class Reservation {

    private final Long id;
    private final String name;
    private final LocalDate date;
    private final LocalTime time;

    public Reservation(String name, LocalDate date, LocalTime time) {
        this(null, name, date, time);
    }

    public Reservation(
            Long id,
            String name,
            LocalDate date,
            LocalTime time
    ) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public LocalDate date() {
        return date;
    }

    public LocalTime time() {
        return time;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof Reservation that
                && Objects.equals(this.id, that.id)
                && Objects.equals(this.name, that.name)
                && Objects.equals(this.date, that.date)
                && Objects.equals(this.time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, time);
    }

    @Override
    public String toString() {
        return "Reservation[" +
                "id=" + id + ", " +
                "name=" + name + ", " +
                "date=" + date + ", " +
                "time=" + time + ']';
    }
}
