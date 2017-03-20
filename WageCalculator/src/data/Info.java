package data;

import java.time.LocalDateTime;

/**
 * Created by OlavH on 09-Feb-17.
 */
public class Info {

    private final LocalDateTime time;
    private String description;

    public Info() {

        time = LocalDateTime.now();
    }
    public Info(String description) {

        time = LocalDateTime.now();
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Info{" + "time=" + time + ", description='" + description + '\'' + '}';
    }
}
