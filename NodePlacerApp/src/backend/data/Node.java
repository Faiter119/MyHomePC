package backend.data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by OlavH on 14-Oct-16.
 */
public class Node implements Comparable<Node>{

    private int nr;
    private int distance;

    private Node previousNode;

    private List<Edge> edgeList;

    public Node(int nr) {
        this.nr = nr;
        edgeList = new ArrayList<>();
    }

    public int getNr() { return nr; }
    public int getDistance() { return distance; }
    public void setDistance(int distance) {this.distance = distance;}
    public void addDistance(int distance){this.distance+=distance;}

    public void addEdgeTo(Node node){
        addEdgeTo(node, 1);
    }
    public void addEdgeTo(Node node, int weight){
        edgeList.add(new Edge(this, node, weight));
    }


    public List<Edge> getEdgeList() {
        return edgeList;
    }
    public List<Node> getConnectedNodes(){

        return edgeList.stream().map(Edge::getTo).collect(Collectors.toList());

    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public boolean equals(Object obj) {
        return obj instanceof Node && nr==((Node) obj).getNr();
    }
    public int hashCode() {
        return nr;
    }
    public int compareTo(Node o) {
        int oNr = o.getNr();
        return nr > oNr ? 1 : nr < oNr ? -1 : 0;
    }

    public String toString() {
        return "{"+nr + "}: "+ edgeList.toString();
    }

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);



    }


}
