

/**
 * This class represents a disk in the Towers of Hanoi
 *
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 * @param size
 */

public record Disk(int size) {

  public int getDiskWidth() {
    return size * 2 + 1;
  }

  @Override
  public String toString() {
    StringBuilder disk = new StringBuilder();
    int disk_width = Math.max(0, getDiskWidth());
    return disk.append("=".repeat(disk_width)).toString();
  }

  public int compareTo(Disk disk) {
    return this.size - disk.size;
  }
}
