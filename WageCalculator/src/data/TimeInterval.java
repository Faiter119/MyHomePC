package data;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by OlavH on 09-Feb-17.
 */
public class TimeInterval implements TemporalAmount, Comparable<TimeInterval>, Serializable {

    private LocalDateTime start;
    private LocalDateTime end;

    public TimeInterval(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public TimeInterval atStart(LocalDateTime start){
        return new TimeInterval(start, end);
    }
    public TimeInterval atEnd(LocalDateTime end){
        return new TimeInterval(start, end);
    }

    @Override
    public String toString() {
        return "TimeInterval{" + "start=" + start + ", end=" + end + '}';
    }

    @Override
    public long get(TemporalUnit unit) {

        return getDuration().get(unit);
    }

    @Override
    public List<TemporalUnit> getUnits() { // Idk what this is for really

        return Arrays.asList(
                ChronoUnit.DAYS,
                ChronoUnit.HOURS,
                ChronoUnit.MINUTES,
                ChronoUnit.SECONDS
        );

    }

    @Override
    public Temporal addTo(Temporal temporal) {
        return temporal.plus(getDuration());
    }

    @Override
    public Temporal subtractFrom(Temporal temporal) {
        return temporal.minus(getDuration());
    }

    private Duration getDuration(){
        return Duration.between(start, end);
    }

    @Override
    public int compareTo(TimeInterval o) {
        return start.isBefore(o.getStart()) ? 1 : start.isAfter(o.getStart()) ? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeInterval that = (TimeInterval) o;

        if (start != null ? !start.equals(that.start) : that.start != null) return false;
        return end != null ? end.equals(that.end) : that.end == null;

    }

    @Override
    public int hashCode() {
        int result = start != null ? start.hashCode() : 0;
        result = 31 * result + (end != null ? end.hashCode() : 0);
        return result;
    }


    public boolean overlaps(TimeInterval interval){

        LocalDateTime iStart = interval.getStart();
        LocalDateTime iEnd = interval.getEnd();

        return !start.isAfter(iEnd) && !iStart.isAfter(end); // For not overlapWith at same min: return start.isBefore(iEnd) && iStart.isBefore(end);

        /*if( start.equals(iStart) || end.equals(iEnd) ) return true;
        if( ((start.isAfter(iStart)) && (end.isBefore(iEnd))) || ((start.isBefore(iStart)) && end.isAfter(iEnd)) ) return true;
        if( (start.isBefore(iStart)) && (end.isAfter(iEnd)) ) return true;
        if( (start.isBefore(iStart) && (end.isBefore(iEnd))) ) return true;
        return false;*/
    }

    public Optional<TimeInterval> overlapWith(TimeInterval interval){

        if(!this.overlaps(interval)) return Optional.empty();

        LocalDateTime iStart = interval.getStart();
        LocalDateTime iEnd = interval.getEnd();

        LocalDateTime s;

        if(start.equals(iStart)){
            s = start;
        }
        else {
            s = start.isBefore(iStart) ? iStart : start;
        }

        LocalDateTime e;

        if(end.equals(iEnd)){
            e = end;
        }
        else {
            e = end.isBefore(iEnd) ? end : iEnd;

        }
        return Optional.of(new TimeInterval(s, e));

    }

}
