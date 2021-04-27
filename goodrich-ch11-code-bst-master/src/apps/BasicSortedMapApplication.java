package apps;

import net.datastructures.SortedMap;
import net.datastructures.SortedTableMap;

public class BasicSortedMapApplication {
    public static void main(String[] args) {
        SortedMap<Integer, String> enrolled = new SortedTableMap<>();
        enrolled.put(254, "CS1210");
        enrolled.put(200, "CS2230");
        enrolled.put(207, "CS2110");

        System.out.println(enrolled.firstEntry());
        System.out.println(enrolled.higherEntry(199));
        System.out.println(enrolled.higherEntry(205));
        System.out.println(enrolled.lowerEntry(207));
        System.out.println(enrolled.get(207));
        System.out.println(enrolled.get(205));
    }
}
