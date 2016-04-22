import java.util.Arrays;

public class Animal implements Comparable{

    private String species;
    private int avgSize;
    private int packSize;

    private Animal(Builder builder){
        this.species = builder.species;
        this.avgSize = builder.avgSize;
        this.packSize = builder.packSize;
    }

    /**
     *@return 1
     */
    public int compareTo(Object o){

        if(!(o instanceof Animal)) throw new ClassCastException();

        Animal a = (Animal)o;

        return Integer.signum(species.compareToIgnoreCase(a.species));

    }
    public String toString(){
        String out = "Species: "+species;

        if (avgSize != -1) out += " -- Average Size: "+avgSize;
        if (packSize != -1) out += " -- Pack Size: "+packSize;

        return out;
    }



    static class Builder{

        // Required Arguments
        private String species;

        // Optional
        private int avgSize = -1;
        private int packSize = -1;

        public Builder(String species){
            this.species = species;
        }

        public Builder size(int size){
            this.avgSize = size;
            return this;
        }
        public Builder pack(int pack){
            this.packSize = pack;
            return this;
        }
        public Animal build(){
            return new Animal(this);
        }
    }


    public static void main(String[]args){

        Animal human1 = new Animal.Builder("Homo Sapiens").pack(4).size(160).build();
        Animal human2 = new Animal.Builder("Homo Erectus").pack(10).size(140).build();
        Animal human3 = new Animal.Builder("Homo Floresiensis").pack(10).size(140).build();
        Animal human4 = new Animal.Builder("Homo Neanderthalensis").pack(10).size(140).build();

        Animal[] animals = new Animal[4];
        animals[0] = human1;
        animals[1] = human2;
        animals[2] = human3;
        animals[3] = human4;


        System.out.println(Arrays.toString(animals));

        Arrays.sort(animals);

        System.out.println(Arrays.toString(animals));




        //System.out.println(human1.compareTo(human2));

    }
}
