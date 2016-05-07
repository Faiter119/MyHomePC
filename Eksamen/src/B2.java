import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class B2 extends RubrikkTypeB {

    public static final double PRIS_PER_LINJE = 77.5;


    public B2(int rubrikkID, String overskrift, List<Annonse> annonser){

        super(rubrikkID,overskrift, annonser);


    }

    public int getInntekt() {
        List<Annonse> annonser = getAnnonser();
        double sum = 0;

        for(Annonse annonse : annonser){
            String text = annonse.getTekst();
            int linjer = text.split("\n").length;

            for(int i=0; i<annonse.getDatoer().size(); i++){
                if(i==0)sum += linjer*PRIS_PER_LINJE;
                else sum += linjer*PRIS_PER_LINJE*RABATT;
            }
        }

        return (int) sum;
    }
}
