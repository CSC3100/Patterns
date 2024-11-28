

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.TreeSet;


/**
 * This class used use to keep track of the current state of the game
 * It also holds our two data structure the current state and the graph for the computer
 * to both check the validity of the move and to find the best move
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class GameState {
    public Node currentState;
    public Graph gameGraph;
    private final Computer computer = new Computer();
    public GameState(int numberOfDisks) {

        final DiskComparator diskComparator = new DiskComparator();
        gameGraph = new Graph();
        TreeSet<Disk> leftTower = new TreeSet<>(diskComparator);
        TreeSet<Disk> middleTower = new TreeSet<>(diskComparator);
        TreeSet<Disk> rightTower = new TreeSet<>(diskComparator);

        for (int i = numberOfDisks; i > 0; i--) {
            leftTower.add(new Disk(i));
        }

        currentState = new Node(leftTower, middleTower, rightTower);

        Deque<Node> notExplored = new ArrayDeque<>();
        HashSet<Node> notExploredSet = new HashSet<>();
        notExplored.add(currentState);
        notExploredSet.add(currentState);
        Node current;
        while (!notExplored.isEmpty()) {
            current = notExplored.pollFirst();
            notExploredSet.remove(current);
            gameGraph.insertNode(current, GameLogic.validNode(current));
            for (Node neighbor : gameGraph.getNeighbor(current)) {
                if (gameGraph.notInGraph(neighbor) && !notExploredSet.contains(neighbor)) {
                    notExplored.add(neighbor);
                    notExploredSet.add(neighbor);
                }
            }
        }
    }

    public void updateCurrentState(Node next) {
        currentState = next;
    }

    public Node getComputerMove(int numberOfDisks) {
        return computer.getBestMove(currentState, gameGraph, numberOfDisks);
    }
}
