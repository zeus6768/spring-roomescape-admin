package roomescape.domain;

import java.util.Objects;

public final class Reservation {

    private final Long id;
    private final String name;
    private final String date;
    private final String time;

    public Reservation(String name, String date, String time) {
        this(null, name, date, time);
    }

    public Reservation(
            Long id,
            String name,
            String date,
            String time
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

    public String date() {
        return date;
    }

    public String time() {
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
