

import java.util.Comparator;

/**
 * This class is used to compare two disks based on their size
 * It is used to help the TreeSet sort the disks in order of size for each pole
 * @author Brian Kwong
 * @author Colin McDonald
 * @version 1.0
 */

public class DiskComparator implements Comparator<Disk> {

    @Override
    public int compare(Disk o1, Disk o2) {
        return o1.size() - o2.size();
    }
}
