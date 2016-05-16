import java.util.ArrayList;
import java.util.List;

public class Apartment {

    private int apartmentNumber;
    private String description = "";
    private List<Room> rooms;

    public Apartment(int apartmentNumber){

        this.apartmentNumber = apartmentNumber;
        this.rooms = new ArrayList<>();

    }

    public int getApartmentNumber() {return apartmentNumber;}
    public double getSquareMeters(){

        double sum = 0;

        for(Room room : rooms){
            room.getSquareMeters();
        }

        return sum;
    }
    public String getDescription() {return description;}

    public void setDescription(String newDescription){description = newDescription;}

    public String toString(){
        return "Apartment "+apartmentNumber+" - "+getSquareMeters()+" square-meters";
    }


    public static void main(String[]args){

        Apartment apartment = new Apartment(1);

        System.out.println(apartment);

    }
}
