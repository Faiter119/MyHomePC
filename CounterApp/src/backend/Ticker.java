package backend;

import java.io.Serializable;

public class Ticker implements Serializable{

    private int count;
    private int defaultAmount;
    private String title;


    public Ticker(String title){
        this(title,1);
    }

    public Ticker(String title, int defaultAmount){
        this.count = 0;
        this.defaultAmount = defaultAmount;
        this.title = title;
    }

    public int getCount(){return count;}
    public int getDefaultAmount(){return defaultAmount;}
    public String getTitle(){return title;}

    public void add(int amount){
        if(amount <= 0) return;
        count += amount;
    }
    public void addDefault(){
        count+=defaultAmount;
    }
    public void remove(int amount){
        if(amount <= 0) return;
        count -= amount;
    }
    public void removeDefault(){
        count-=defaultAmount;
    }

    public String toString() {
        return title+": ("+count+")";
    }

    public static void main(String[] args) {

        Ticker uefWins = new Ticker("UEF Wins");

        uefWins.addDefault();
        uefWins.removeDefault();
        uefWins.add(10);

        System.out.println(uefWins);

    }
}
