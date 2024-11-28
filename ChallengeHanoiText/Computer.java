

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

/**
 * This class is responsible as the computer player of the game
 * It finds the best next possible move given the current state of the game
 * using BFS search
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class Computer {
  private static class NodeDistance {
    public Node node;
    public int distanceFrom;
    public Node previousNode;

    public NodeDistance(Node current, int distanceFrom, Node previousNode) {
      this.node = current;
      this.distanceFrom = distanceFrom;
      this.previousNode = previousNode;
    }

    public void updateDistance(int distanceFrom, Node previousNode) {
      this.distanceFrom = distanceFrom;
      this.previousNode = previousNode;
    }

    public String toString() {
      return "Node: " + node + " Distance: " + distanceFrom;
    }
  }

  public Node getBestMove(Node start, Graph graph, int numberOfDisks) {
    Deque<Node> notExplored = new ArrayDeque<>();
    HashMap<Node, NodeDistance> entries = new HashMap<>();
    ArrayList<NodeDistance> endStates = new ArrayList<>();
    Node current;
    notExplored.add(start);
    entries.put(start, new NodeDistance(start, 0, null));
    while (!notExplored.isEmpty()) {
      current = notExplored.pollFirst();
      ArrayList<Node> neighbors = graph.getNeighbor(current);
      for (Node neighbor : neighbors) {
        if (entries.containsKey(neighbor)) {
          if (entries.get(current).distanceFrom + 1 < entries.get(neighbor).distanceFrom) {
            entries.get(neighbor).updateDistance(entries.get(current).distanceFrom + 1, current);
          }
        } else if (GameLogic.hasWon(neighbor, numberOfDisks)) {
          NodeDistance endState =
              new NodeDistance(neighbor, entries.get(current).distanceFrom + 1, current);
          endStates.add(endState);
          entries.put(neighbor, endState);
        } else {
          notExplored.add(neighbor);
          entries.put(
              neighbor, new NodeDistance(neighbor, entries.get(current).distanceFrom + 1, current));
        }
      }
    }
    int minDistance = Integer.MAX_VALUE;
    NodeDistance nextMove = null;
    for(NodeDistance endState : endStates){
      if(endState.distanceFrom < minDistance){
        minDistance = endState.distanceFrom;
        nextMove = endState;
      }
    }
    while (nextMove != null && nextMove.previousNode != start) {
      nextMove = entries.get(nextMove.previousNode);
    }
      assert nextMove != null;
      return nextMove.node;
  }
}
