package backend.javaBackend;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Post {

    private LocalDateTime added;
    private String title;
    private List<String> steps = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();

    public Post(String title){

        if (title == null) throw new IllegalArgumentException("Title is null");

        this.added = LocalDateTime.now();
        this.title = title;

    }

    public String getTitle() {
        return title;
    }
    public LocalDateTime getAdded() {
        return added;
    }

    public void addCategory(Category category){
        if (category != null){
            categories.add(category);
        }
    }
    public void addCategories(Category ... categories){

        for (Category category: categories) {
            this.categories.add(category);
        }

    }

    public Collection<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public void addStep(String item){
        if (item != null && !item.equals("")){
            steps.add(item);
        }
    }
    public void addSteps(String ... steps){

        for (String step : steps) this.steps.add(step);

    }
    public Collection<String> getSteps(){
        return new ArrayList<>(steps); // Shallow copy
    }

    public String toString() {

        String out = "*"+title+"*\n---\n";

        for (Category cathegory: categories) {
            out += cathegory+"\n";
        }
        out+= "---\n";

        for (String step : steps) {
            out += step+"\n";
        }
        return out;
    }

    public static void main(String[] args) {


        Post post = new Post("Silo-ordering");
        post.addCategories(
                Category.ROUTINE,
                Category.MHSSOS,
                Category.SILO
        );
        post.addSteps(
                "MHS-SOS",
                "L3f",
                "SM: 2",
                "random stuff I dont remember"
                );

        System.out.println(post);

    }
}
