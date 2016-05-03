import java.util.ArrayList;
import java.util.List;

public class AnnonseRegister{

    private List<Rubrikk> rubrikker;

    public AnnonseRegister(List<Rubrikk> rubrikker){

        this.rubrikker = rubrikker;

    }

    public Rubrikk leggTilRubrikk(Class klasse, int id, String overskrift){

        Rubrikk rubrikk = null;

        if(klasse == A1.class){
            rubrikk = new A1(id, overskrift, new ArrayList<>());
            if(registerContains(overskrift,id)) return null;
            rubrikker.add(rubrikk);

        }
        //osv
        return rubrikk;
    }
    public boolean registerContains(String navn, int id){

        for(Rubrikk rubrikk : rubrikker){
            if(rubrikk.getOverskrift().equals(navn) || rubrikk.getRubrikkID()==id) return true;
        }

        return false;
    }
}