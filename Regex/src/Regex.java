import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args){

        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher("huiasdguio78");
        matcher.matches();

        // Same as

        System.out.println(Pattern.matches("[0-9]{5}","42560"));
        System.out.println(Pattern.matches("\\d{5}","42560"));

        System.out.println(Pattern.matches("\\d{2}\\s[a-zA-ZæøåÆØÅ]{4}","12 åæåq"));

    }
}
