import java.time.LocalTime;
import java.util.Optional;

public class TimeInterval {

    private LocalTime start;
    private LocalTime end;

    public TimeInterval(LocalTime start, LocalTime end){

        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() { return start; }
    public LocalTime getEnd() { return end; }

    public boolean overlaps(TimeInterval interval){

        LocalTime iStart = interval.getStart();
        LocalTime iEnd = interval.getEnd();

        return !start.isAfter(iEnd) && !iStart.isAfter(end); // For not overlapWith at same min: return start.isBefore(iEnd) && iStart.isBefore(end);

        /*if( start.equals(iStart) || end.equals(iEnd) ) return true;
        if( ((start.isAfter(iStart)) && (end.isBefore(iEnd))) || ((start.isBefore(iStart)) && end.isAfter(iEnd)) ) return true;
        if( (start.isBefore(iStart)) && (end.isAfter(iEnd)) ) return true;
        if( (start.isBefore(iStart) && (end.isBefore(iEnd))) ) return true;
        return false;*/
    }
    public Optional<TimeInterval> overlapWith(TimeInterval interval){

        if(!this.overlaps(interval)) return Optional.empty();

        LocalTime iStart = interval.getStart();
        LocalTime iEnd = interval.getEnd();

        LocalTime s;

        if(start.equals(iStart)){
            s = start;
        }
        else {
            s = start.isBefore(iStart) ? iStart : start;
        }

        LocalTime e;

        if(end.equals(iEnd)){
            e = end;
        }
        else {
            e = end.isBefore(iEnd) ? end : iEnd;

        }
        return Optional.of(new TimeInterval(s, e));

    }
    public boolean hasDays(){
        return false;
    }
    public TimeInterval of(Event event){
        return new TimeInterval(event.getStart(), event.getEnd());
    }

    public String toString() {
        return start+" -> "+end;
    }

    public static void main(String[] args) {

        TimeInterval i0 = new TimeInterval(LocalTime.of(10,0), LocalTime.of(14,0));
        TimeInterval i1 = new TimeInterval(LocalTime.of(6,0), LocalTime.of(18,0));

        System.out.println(i0.overlaps(i1));

        i0.overlapWith(i1).ifPresent( (optional)-> {System.out.println(optional+"");});

    }
}
