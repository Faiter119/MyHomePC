import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Annonse{

    private int annonseID;
    private String tekst;
    private List<LocalDate> datoer;
    private String navn;
    private String adr;

    public Annonse(int annonseID, String tekst, String navn, String adr){
        this.annonseID = annonseID;
        this.tekst = tekst;
        this.datoer = new ArrayList<>();
        this.navn = navn;
        this.adr = adr;
    }

    public int getID(){return annonseID;}
    public String getTekst(){return tekst;}
    public String getNavn(){return navn;}
    public String getAdr(){return adr;}

    public void setTekst(String ny){tekst = ny;}
    public void setNavn(String ny){navn = ny;}
    public void setAdr(String ny){adr = ny;}


    /**
     * Returner en kopi fordi List er mutabel, men LocalDate er ikke det
     */
    public List<LocalDate> getDatoer(){return new ArrayList<>(datoer);}



}