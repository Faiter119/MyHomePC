import java.time.LocalDate;
import java.util.List;

public class B1 extends RubrikkTypeB {

    public static final int PRIS_PER_TEGN = 7;

    public B1(int rubrikkID, String overskrift, List<Annonse> annonser){

        super(rubrikkID,overskrift, annonser);

    }

    int getInntekt() {
        List<Annonse> annonser = getAnnonser();
        double sum = 0;

        for(Annonse annonse : annonser){

            String text = annonse.getTekst();
            int tegn = text.split("").length;

            for(int i=0; i<annonse.getDatoer().size(); i++){

                if(i==0) sum += tegn*PRIS_PER_TEGN;
                else sum += tegn*PRIS_PER_TEGN*RABATT;

            }
        }
        return (int) sum; // rip livet
    }
}
