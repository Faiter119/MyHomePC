package backend.javaBackend;


import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PostManager {


    private List<Post> postList = new ArrayList<>();
    private Path saveDir;

    public PostManager(){
        saveDir = Paths.get(System.getProperty("user.home"));
    }

    public void addPost(Post post){

        if (post.getCategories() != null && post.getSteps() != null && post.getTitle() != null) return;

        postList.add(post);

    }
    public boolean write(){

        Path path = Paths.get(System.getProperty("user.home"));

        System.out.println(path.toFile().toString());

        return false;

    }



    public static void main(String[] args) {

        PostManager manager = new PostManager();

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

        manager.addPost(post);
        manager.write();
        manager.setSaveDir();

    }
}
