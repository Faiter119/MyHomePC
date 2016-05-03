import java.util.ArrayList;
import java.util.List;


public class Rubrikk{

    private int rubrikkID;
    private String overskrift;
    private List<Annonse> annonser;

    public Rubrikk(int rubrikkID, String overskrift, List<Annonse> annonser){

        this.rubrikkID = rubrikkID;
        this.overskrift = overskrift;
        this.annonser = annonser;

    }
    public int getRubrikkID(){return rubrikkID;}
    public String getOverskrift(){return overskrift;}

    public List<Annonse> getAnnonser(){
        List<Annonse> temp = new ArrayList<>();
        temp.addAll(annonser);
        return temp;
    }
    public boolean leggTilAnnonse(Annonse annonse){
        return annonser.add(annonse);
    }

    public int getInntekt(){return 0;}

}