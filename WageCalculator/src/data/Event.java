package data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by OlavH on 09-Feb-17.
 */
public class Event implements Serializable{

    private TimeInterval timeInterval;
    private Info info;

    public Event(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
        info = new Info();

    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public Info getInfo() {
        return info;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public String toString() {
        return "Event{" + "timeInterval=" + timeInterval + ", info=" + info + '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (timeInterval != null ? !timeInterval.equals(event.timeInterval) : event.timeInterval != null) return false;
        return info != null ? info.equals(event.info) : event.info == null;

    }

    @Override
    public int hashCode() {
        int result = timeInterval != null ? timeInterval.hashCode() : 0;
        result = 31 * result + (info != null ? info.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

        Event event = new Event(new TimeInterval(LocalDateTime.now(), LocalDateTime.now().plusDays(1)));

        System.out.println(event);

    }
}
