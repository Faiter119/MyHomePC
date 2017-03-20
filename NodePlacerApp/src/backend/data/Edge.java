package backend.data;

/**
 * Created by OlavH on 14-Oct-16.
 */
public class Edge {

    private Node from;
    private Node to;

    private int weight;

    public Edge(Node from, Node to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public Edge(Node from, Node to) {
        this(from, to, 1);
    }


    public int getWeight() {return weight;}
    public void setWeight(int weight) {this.weight = weight;}

    public Node getFrom() {return from;}
    public Node getTo() {return to;}

    public String toString() {
        return " -> {"+to.getNr()+"}("+weight+")";
    }
}
