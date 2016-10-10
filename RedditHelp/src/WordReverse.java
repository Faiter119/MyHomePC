import java.util.stream.Stream;

public class WordReverse {

    public static String reverse(String string){

        char[] chars = string.toCharArray();

        char[] out = new char[chars.length];

        int counter = 0;
        for(int i=chars.length-1; i>=0; i--){

            out[counter++] = chars[i];

        }

        return new String(out);
    }

    public static void main(String[] args) {

        String word = "This is a word I've heard.";

        System.out.println(reverse(word));

    }

}
