
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents a 2D undirected graph
 * Each node is represented as a entry in the HashMap
 * Meanwhile each edge is represented as a list of neighbors
 * Each vertex represents the state of the game
 * while the edges represent the possible moves from that state
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class Graph {
    final private HashMap<Node, ArrayList<Node>> graph = new HashMap<>();

    public Graph(){
    }

    public int  size(){
        return graph.size();
    }

    public void insertNode(Node node, ArrayList<Node> neighbors){
        graph.put(node, neighbors);
    }

    public boolean notInGraph(Node node){
        return !graph.containsKey(node);
    }

    public ArrayList<Node> getNeighbor(Node node){
        return graph.get(node);
    }

    public boolean areNeighbors(Node node1, Node node2){
        return graph.get(node1).contains(node2);
    }

    @Override
    public String toString(){
        return graph.toString();
    }
}
