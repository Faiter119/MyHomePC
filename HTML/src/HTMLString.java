import javax.swing.text.html.HTML;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * String-wrapper to HTML-stuff?
 */
public class HTMLString {

    private String string;

    private HTMLString(Builder builder){
        this.string = builder.string;
    }
    public static void printHTML(HTMLString htmlString){

        String[] elements = htmlString.toString().split("");
        // System.out.println(Arrays.toString(elements));

        //
        for(int i=1; i<elements.length-1; i++){

            String prevElement = elements[i-1];
            String element = elements[i];
            String nextElement = elements[i+1];

            if(element.equals("<") && !nextElement.equals("/")) {
                System.out.println();
            }
            System.out.print(element);
        }
        //
    }
    public boolean writeToFile(String filename){
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8"); // PrintWriter = Quick and dirty, BufferedWriter = More Efficient
            writer.write(string);
            writer.close();
            return true;
        }
        catch (Exception e){return false;}
    }

    @Override
    public String toString(){
        return string;
    }
    // Builder Class
    public static class Builder{

        private String string;

        public Builder(String string){
            this.string = string;
        }

        public Builder doctype(){ // Type of HTML doc
            this.string = "<!DOCTYPE html>"+string;
            return this;
        }
        public Builder html(){ // Start of HTML doc
            this.string = "<html>"+string+"</html>";
            return this;
        }
        public Builder head(){ // Header aka information about the doc
            this.string = "<head>"+string+"</head>";
            return this;
        }
        public Builder title(){ // Title of the HTML doc
            this.string = "<title>"+string+"</title>";
            return this;
        }
        public Builder body(){ // Describes visible page content
            this.string = "<body>"+string+"</body>";
            return this;
        }
        public Builder heading(int number){
            this.string = "<h"+number+">"+string+"</h"+number+">";
            return this;
        }
        public Builder paragraph(){ // Describes a paragraph
            this.string = "<p>"+string+"</p>";
            return this;
        }
        public Builder unorderedList(String ... items){
            String out = "<ul>"; // Unordred List "ul / UL"

            for(String item : items){
                item = "<li>"+item+"</li>"; // "List Item "li""
                out+= item;
            }
            out+="</ul>";

            this.string = out;
            return this;
        }
        public HTMLString build(){
            return new HTMLString(this);
        }
    }
    // Builder Class


    public static void main(String[]args){

        // <br> = \n
        HTMLString header = new HTMLString.Builder("Made by Faiter119").heading(1).build();
        HTMLString paragraph = new HTMLString.Builder("Damn son aint that some shit right there,<br> mhm yea that's some good shit right there if I do say so myself. <br>I do say so!").paragraph().build();
        HTMLString list = new HTMLString.Builder("List").unorderedList("Chese","Pizza","Taco","Good Shit","PCMR").build();

        HTMLString combo = new HTMLString.Builder(""+header+list+paragraph).body().html().doctype().build();
        System.out.println(combo);
        System.out.println(combo.writeToFile("./HTML/src/myWebSite.html"));
/*

        HTMLString simpleParagraph = new HTMLString.Builder("Im a simple paragraph-website!")
                .paragraph().body().html().doctype().build();
*/

      //  simpleParagraph.writeToFile("./HTML/src/myWebSite.html");

    }
}
