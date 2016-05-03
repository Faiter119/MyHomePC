import java.util.List;

abstract class RubrikkTypeB extends Rubrikk{

    public static final double RABATT = 0.75; // Precision ikke confirmed

    public RubrikkTypeB(int rubrikkID, String overskrift, List<Annonse> annonser){
        super(rubrikkID,overskrift,annonser);

    }
}
