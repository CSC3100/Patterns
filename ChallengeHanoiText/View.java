

import java.util.Iterator;
import java.util.TreeSet;

/**
 * This class is the view to TTY
 * It prints to the screen messages and the game screen
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class View {
  public void print(String message) {
    System.out.println(message);
  }

  private String drawDisk(Disk disk, int width) {
    return " ".repeat((width - disk.getDiskWidth()) / 2)
        + disk
        + " ".repeat((width - disk.getDiskWidth()) / 2);
  }

  private Iterator<Disk>  treeToIterator(TreeSet<Disk> tower){
    return tower.iterator();
  }

  public void drawBoard(
      TreeSet<Disk> leftTower,
      TreeSet<Disk> middleTower,
      TreeSet<Disk> rightTower,
      int numberOfDisks) {
    final int height =
        Math.max(leftTower.size(), Math.max(middleTower.size(), rightTower.size())) + 1;
    final int width = (2 * numberOfDisks + 1) + 2;
    StringBuilder string = new StringBuilder();
    Iterator<Disk> left, middle, right;
    left = treeToIterator(leftTower);
    middle = treeToIterator(middleTower);
    right = treeToIterator(rightTower);

    for (int i = height - 1; i > 0; i--) {
      if (leftTower.size() >= i) {
        string.append(drawDisk(left.next(), width));
      } else {
        string.append(" ".repeat(width/2)).append("|").append(" ".repeat(width/2));
      }
//      string.append("||");
      if (middleTower.size() >= i) {
        string.append(drawDisk(middle.next(), width));
      } else {
        string.append(" ".repeat(width/2)).append("|").append(" ".repeat(width/2));
      }
//      string.append("||");
      if (rightTower.size() >= i) {
        string.append(drawDisk(right.next(), width));
      } else {
        string.append(" ".repeat(width/2)).append("|").append(" ".repeat(width/2));
      }
      string.append("\n");
    }
    string.append("-".repeat(width * 3 + 2));
    print(string.toString());
  }
}
