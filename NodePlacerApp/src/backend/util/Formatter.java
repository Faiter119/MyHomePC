package backend.util;

import backend.data.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by OlavH on 04-Oct-16.
 */
public class Formatter {

    public enum SortingOrder {

        DISTANCE_ASC,
        DISTANCE_DSC,
        NODE_NR_ASC,
        NODE_NR_DSC
    }

    public static String format(List<Node> nodeDistanceList, SortingOrder sortingOrder){

        switch (sortingOrder) {

            case NODE_NR_ASC:
                Collections.sort(nodeDistanceList);
                break;

            case NODE_NR_DSC:
                Collections.sort(nodeDistanceList);
                Collections.reverse(nodeDistanceList);
                break;

            case DISTANCE_ASC:

                nodeDistanceList.sort(Comparator.comparing(
                        Node::getDistance
                ));

                break;

            case DISTANCE_DSC:
                nodeDistanceList.sort(Comparator.comparing(
                        Node::getDistance
                ));
                Collections.reverse(nodeDistanceList);
                break;
        }
        return format(nodeDistanceList);
    }

    public static String format(List<Node> nodeDistanceList){
        if (nodeDistanceList == null || nodeDistanceList.size() == 0) return "";

        StringBuilder out = new StringBuilder("| Node \t| Dist \t| Prev \t|\n" +
                "|-----------------------|\n");

        for (Node node : nodeDistanceList) {

            int distance = node.getDistance();
            Node prev = node.getPreviousNode();

            //out.append("| ") += "| "+node.getNr() + " \t| " +(distance==Integer.MAX_VALUE ? "Null":distance) + " \t| "+((prev==null) ? "Null" : prev.getNode().getNr()+"\t")+"\t|\n";
            out.append("| ");
            out.append(node.getNr());
            out.append(" \t| ");
            out.append(distance==Integer.MAX_VALUE ? "Null":distance);
            out.append(" \t| ");
            out.append((prev==null) ? "Null" : prev.getNr());
            out.append("\t");
            out.append("\t|\n");
        }

        return out+"|_______________________|";

    }

    public static String formatGraph(Graph graph){

        StringBuilder builder = new StringBuilder();

        List<Node> nodeList = graph.getNodeList();

        for (Node node : nodeList) {

            builder.append(node.getNr());

            for (Edge edge : node.getEdgeList()) {

                builder.append("\n\t");
                builder.append(edge);

            }

            builder.append("\n");
        }



        return builder.toString();
    }
}
