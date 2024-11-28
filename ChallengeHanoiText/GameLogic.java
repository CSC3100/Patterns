

import java.util.*;

public class GameLogic {

  private static Node cloneCurrentState(Node curr) {
    try {
      return curr.clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeException(e);
    }
  }

  public static ArrayList<Node> validNode(Node node) {
    Disk leftSmallestDisk =
        node.getLeftTop() == null ? new Disk(Integer.MAX_VALUE) : node.getLeftTop();
    Disk middleSmallestDisk =
        node.getMiddleTop() == null ? new Disk(Integer.MAX_VALUE) : node.getMiddleTop();
    Disk rightSmallestDisk =
        node.getRightTop() == null ? new Disk(Integer.MAX_VALUE) : node.getRightTop();
    ArrayList<Node> validMoves = new ArrayList<>();
    Node next;

    if (leftSmallestDisk.compareTo(middleSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskMiddle(next.left().pollFirst());
      validMoves.add(next);
    }
    if (leftSmallestDisk.compareTo(rightSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskRight(next.left().pollFirst());
      validMoves.add(next);
    }
    if (middleSmallestDisk.compareTo(leftSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskLeft(next.middle().pollFirst());
      validMoves.add(next);
    }
    if (middleSmallestDisk.compareTo(rightSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskRight(next.middle().pollFirst());
      validMoves.add(next);
    }

    if (rightSmallestDisk.compareTo(leftSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskLeft(next.right().pollFirst());
      validMoves.add(next);
    }

    if (rightSmallestDisk.compareTo(middleSmallestDisk) < 0) {
      next = cloneCurrentState(node);
      next.addDiskMiddle(next.right().pollFirst());
      validMoves.add(next);
    }

    return validMoves;
  }

  public Node convertStringToNodeMove(Node current, int from, int to) {
    Node next = cloneCurrentState(current);
    Disk fromDisk = null;
    switch (from) {
      case 1 -> fromDisk = next.left().pollFirst();
      case 2 -> fromDisk = next.middle().pollFirst();
      case 3 -> fromDisk = next.right().pollFirst();
    }
    if(fromDisk == null){
      return null;
    }
    switch (to) {
      case 1 -> next.addDiskLeft(fromDisk);
      case 2 -> next.addDiskMiddle(fromDisk);
      case 3 -> next.addDiskRight(fromDisk);
    }
    return next;
  }

  public boolean checkIfValidMove(Graph g, Node current, Node next) {
    return next != null && g.areNeighbors(current, next);
  }

  public static boolean hasWon(Node node, int numberOfDisks) {
    return node.right().size() == numberOfDisks || node.middle().size() == numberOfDisks;
  }

  public Graph buildGraph(Node start) {
    Graph gameGraph = new Graph();
    Deque<Node> notExplored = new ArrayDeque<>();
    HashSet<Node> notExploredSet = new HashSet<>();
    notExplored.add(start);
    notExploredSet.add(start);
    Node current;
    while (!notExplored.isEmpty()) {
      current = notExplored.pollFirst();
      notExploredSet.remove(current);
      gameGraph.insertNode(current, validNode(current));
      for (Node neighbor : gameGraph.getNeighbor(current)) {
        if (gameGraph.notInGraph(neighbor) && !notExploredSet.contains(neighbor)) {
          notExplored.add(neighbor);
          notExploredSet.add(neighbor);
        }
      }
    }
    return gameGraph;
  }
}
