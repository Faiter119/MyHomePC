package backend.data;

import java.util.List;

/**
 * Created by OlavH on 14-Oct-16.
 */
public class Graph {

    private List<Node> nodeList;

    private int numberOfEdges;
    private int numberOfNodes;

    public Graph(List<Node> nodeList, int numberOfEdges, int numberOfNodes) {
        this.nodeList = nodeList;
        this.numberOfEdges = numberOfEdges;
        this.numberOfNodes = numberOfNodes;
    }

    public int getNumberOfEdges() {return numberOfEdges;}
    public int getNumberOfNodes() {return numberOfNodes;}

    public List<Node> getNodeList() {return nodeList;}
}
