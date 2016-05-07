import java.time.LocalDate;
import java.util.List;

public class A1 extends RubrikkTypeA {

    public static final int PRIS_PER_INNTRYKK = 75;

    public A1(int rubrikkID, String overskrift, List<Annonse> annonser){

        super(rubrikkID,overskrift, annonser);

    }

    public int getInntekt() {
        List<Annonse> annonser = getAnnonser();
        int sum = 0;

        for(Annonse annonse : annonser){
            for(LocalDate dato : annonse.getDatoer()){
                sum += PRIS_PER_INNTRYKK;
            }
        }

        return sum;
    }
}
