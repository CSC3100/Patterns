

import java.util.NoSuchElementException;
import java.util.TreeSet;

/**
 * This class represents a node in the game of Towers of Hanoi
 * Each node represents a state of the game
 * which includes all three towers and their respective disks
 * @param left
 * @param middle
 * @param right
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public record Node(TreeSet<Disk> left, TreeSet<Disk> middle, TreeSet<Disk> right) {

  public Disk getLeftTop() {
    try {
      return left.first();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public Disk getMiddleTop() {
    try {
      return middle.first();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public Disk getRightTop() {
    try {
      return right.first();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public void addDiskLeft(Disk disk) {
    left.add(disk);
  }

  public void addDiskMiddle(Disk disk) {
    middle.add(disk);
  }

  public void addDiskRight(Disk disk) {
    right.add(disk);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Node node) {
      return left.equals(node.left) && middle.equals(node.middle) && right.equals(node.right);
    }
    return false;
  }

  @Override
  public Node clone() throws CloneNotSupportedException {
    return new Node(new TreeSet<>(left), new TreeSet<>(middle), new TreeSet<>(right));
  }

  @Override
  public String toString() {
    return "Node{" +
        "left=" + left + "\n" +
        ", middle=" + middle + "\n" +
        ", right=" + right +  "\n" +
        '}';
  }
}
