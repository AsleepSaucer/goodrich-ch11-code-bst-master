package apps;

// Java library's equivalent to the Sorted Set ADT in the textbook
import java.util.NavigableSet;
// One of Java library's implementations of NavigableSet
import java.util.TreeSet;

public class BasicSortedSetApplication {
    public static void main(String[] args) {
        NavigableSet<Integer> numbers = new TreeSet<>();
        numbers.add(254);
        numbers.add(200);
        numbers.add(207);

        System.out.println(numbers.first());
        System.out.println(numbers.ceiling(199));
        System.out.println(numbers.ceiling(205));
        System.out.println(numbers.floor(207));
        System.out.println(numbers.contains(207));
        System.out.println(numbers.contains(205));
    }
}
