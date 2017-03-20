package backend.util;

import backend.data.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by OlavH on 28-Sep-16.
 */
public class GraphReader {

    private Path path;
    private List<String> lines;

    private int numberOfNodes;
    private int numberOfEdges;

    public GraphReader(Path path) throws IOException {

        this.path = path;
        this.lines = Files.readAllLines(path);

        this.numberOfNodes = Integer.parseInt(lines.get(0).split("\\s")[0]);
        this.numberOfEdges = Integer.parseInt(lines.get(0).split("\\s")[1]);

        lines.remove(0);
    }


    public Graph buildGraph(){

        return new Graph(new ArrayList<>(parseNodes().values()), numberOfNodes, numberOfEdges);
    }

    public Map<Integer, Node> parseNodes(){
        //System.out.println("Starting Parsing Nodes...");

        Map<Integer, Node> nodeMap = new HashMap<>(lines.size());

        for (String line : lines) {

            // Seff forskjellig format på alle tekstfilene da
            line = line.replaceAll("^\\s+",""); // ^ = start of line
            line = line.replaceAll("\\s+"," "); // 1 or several spaces

            String[] elements = line.split("\\s");

            if (elements[0].equals("") || elements[1].equals("")){continue;} // If end of file

            int fromId = Integer.parseInt(elements[0]);
            int toId = Integer.parseInt(elements[1]);
            int weight = Integer.parseInt(elements[2]);

            if (!nodeMap.containsKey(fromId)) nodeMap.put(fromId, new Node(fromId));
            if (!nodeMap.containsKey(toId)) nodeMap.put(toId, new Node(toId));

            Node from = nodeMap.get(fromId);
            Node to = nodeMap.get(toId);

            from.addEdgeTo(to, weight);
        }
        //System.out.println("Finished Parsing Nodes");
        return nodeMap;
    }
    public static void main(String[] args) throws IOException {

        GraphReader reader = new GraphReader(Paths.get("./NodePlacerApp/files/vg1.txt"));



        Map<Integer, Node> nodeMap = reader.parseNodes();

        nodeMap.forEach((integer, node) -> {
            System.out.println(node);
        });
        /*System.out.println(reader.buildGraph().getNodeList());
        System.out.println(nodeMap);*/

    }
}