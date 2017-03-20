import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by OlavH on 17-Feb-17.
 */
public class BonusMedlem {

    private int medlNr;
    private String personalia;
    private LocalDate date;
    private int poeng;

    public BonusMedlem(int medlNr, String personalia, LocalDate date, int poeng) {
        this.medlNr = medlNr;
        this.personalia = personalia;
        this.date = date;
        this.poeng = poeng;
    }

    public int getMedlNr() {
        return medlNr;
    }

    public void setMedlNr(int medlNr) {
        this.medlNr = medlNr;
    }

    public String getPersonalia() {
        return personalia;
    }

    public void setPersonalia(String personalia) {
        this.personalia = personalia;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPoeng() {
        return poeng;
    }

    public void setPoeng(int poeng) {
        this.poeng = poeng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BonusMedlem that = (BonusMedlem) o;

        if (medlNr != that.medlNr) return false;
        if (poeng != that.poeng) return false;
        if (personalia != null ? !personalia.equals(that.personalia) : that.personalia != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;

    }

    @Override
    public int hashCode() {
        int result = medlNr;
        result = 31 * result + (personalia != null ? personalia.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + poeng;
        return result;
    }

    @Override
    public String toString() {
        return "BonusMedlem{" + "medlNr=" + medlNr + ", personalia='" + personalia + '\'' + ", date=" + date + ", poeng=" + poeng + '}';
    }

    public static void main(String[] args) {


        BonusMedlem bonusMedlem = new BonusMedlem(10, "ost", LocalDate.now(), 0);

        System.out.println(bonusMedlem);

        LocalDate now = LocalDate.now();

        System.out.println(DAYS.between(now, LocalDate.of(2019, 1, 1)));


    }


}
