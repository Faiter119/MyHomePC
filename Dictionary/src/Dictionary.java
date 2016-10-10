import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Dictionary {

    private List<String> wordList;

    public Dictionary(){

        Path path = Paths.get("dictionary.txt");

        try {
            wordList = Files.readAllLines(path);
            wordList.sort(String::compareTo); // Sort alphabetically
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<String> getWordList(){return wordList;}
    public void setWords(List<String> list){ wordList = list; }


    public List<String> search(String query){

        // Arrays.binarySearch(wordList.toArray(), query);

        List<String> results = new ArrayList<>();

        for(String word : wordList){

            System.out.println(word);

            if (word.toLowerCase().contains(query.toLowerCase())) results.add(word);
        }
        return results;
    }
    public List<String> getLatinWords(){

        List<String> latinWords = new ArrayList<>();

        wordList.stream().filter(this::isLatin).forEach(latinWords::add);

        return latinWords;
    }
    public boolean isLatin(String word){
        char[] chars = word.toCharArray();

        for (char c : chars){
            if (!isLatinLetter(c)) return false;
        }
        return true;
    }
    public static boolean isLatinLetter(char c) {
        c = Character.toLowerCase(c);
        return ((c >= 'a' && c <= 'z' || c=='æ' || c=='ø' || c=='å' )); // fuck other languages
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Dictionary dict = new Dictionary();

        //List<String> words = dict.search("Norway");

        //words.stream().forEach(System.out::println);

        dict.getWordList().stream().forEach(System.out::println);
        List<String> words = dict.getLatinWords();

        words.stream().filter( s -> s.contains("ø") ).forEach(System.out::println);

        System.out.println("Time: "+(System.currentTimeMillis()-start));
    }

}
