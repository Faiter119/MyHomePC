import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class XMLTest {

    public static void main(String[]args) throws Exception { // Yolllooo


        File inputFile = new File("XML/src/input.txt");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("student");

        System.out.println("----------------------------");
        for (int i = 0; i < nList.getLength(); i++) {

            Node nNode = nList.item(i);

            System.out.println("\nCurrent Element :"+ nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element currentElement = (Element) nNode;

                System.out.println("Student roll no : "+ currentElement.getAttribute("rollno"));
                System.out.println("First Name : "+ currentElement.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("Last Name : "+ currentElement.getElementsByTagName("lastname").item(0).getTextContent());
                System.out.println("Nick Name : "+ currentElement.getElementsByTagName("nickname").item(0).getTextContent());
                System.out.println("Marks : "+ currentElement.getElementsByTagName("marks").item(0).getTextContent());
            }

        }

    }
}
