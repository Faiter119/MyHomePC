
public class Card {

    enum Sort{SPADES, CLUBS, HEARTS, DIAMONDS}


    private Sort sort;
    private int value;

    public Card(Sort sort, int value){

        this.sort = sort;
        this.value = value;

    }
    public String toString(){
        return sort.toString()+" - "+value;
    }


    public static void main(String[]args){

        Card aceOfSpades = new Card(Sort.SPADES, 1);

        System.out.println(aceOfSpades);

    }

}
