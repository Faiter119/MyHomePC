import java.io.Serializable;

public class Room implements Serializable{

    public enum Type {
        Bedroom,
        Kitchen,
        Livingroom,
        Bathroom,
        Empty
    }

    private double squareMeters;
    private Type type;

    public Room(Type type, double squareMeters){
        this.type = type;
        this.squareMeters = squareMeters;
    }

    public double getSquareMeters() {
        return squareMeters;
    }
    public Type getType(){
        return type;
    }

    public String toString(){

        return type.toString()+" - "+Double.toString(squareMeters)+" square meters";
    }

    public static void main(String[]args){

        Room room = new Room(Type.Bedroom, 10);
        System.out.println(room);
    }

}
