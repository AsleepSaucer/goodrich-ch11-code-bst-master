import net.datastructures.Entry;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import net.datastructures.TreeMap;

import java.util.LinkedList;
import java.util.List;

public class Lab14 {
    public static void checkEquals(Object o1, Object o2) {
        if (o1 == null) {
            if (o2 == null) return;
            throw new RuntimeException("expected " + o1 + " actual " + o2);
        } else {
            if (!o1.equals(o2)) {
                throw new RuntimeException("expected " + o1 + " actual " + o2);
            }
        }
    }

    private static void checkIterable(String[] expected, Iterable<Entry<Integer, String>> actual) {
        int i = 0;
        for (Entry<Integer, String> e : actual) {
            checkEquals(expected[i], e.getValue());
            i++;
        }
    }

    private static <E> Iterable<E> positionsToElements(Iterable<Position<E>> i) {
        List<E> l = new LinkedList<>();
        for (Position<E> e : i) {
           l.add(e.getElement());
        }
        return l;
    }

    public static void main(String[] args) {
        // test preorder iterative
        LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
        Position<Integer> root = t.addRoot(90);
        Position<Integer> L = t.addLeft(root, 40);
        Position<Integer> R = t.addRight(root, 50);
        Position<Integer> LL = t.addLeft(L, 30);
        Position<Integer> RR = t.addRight(R, 70);
        Position<Integer> LLL = t.addLeft(LL, 20);
        Position<Integer> RRL = t.addLeft(RR, 100);
        Position<Integer> LLLR = t.addRight(LLL, 10);
        Position<Integer> LLLL = t.addLeft(LLL, 0);

        checkEquals(positionsToElements(t.preorder()), positionsToElements(t.preorderIterative()));
        System.out.println("passed preorderIterative");

        // test TreeMap
        TreeMap<Integer, String> m = new TreeMap<>();
        checkEquals(null, m.putIfAbsent(300, "A"));
        checkEquals(null, m.putIfAbsent(200, "B"));
        checkEquals(null, m.putIfAbsent(100, "C"));
        checkEquals(null, m.putIfAbsent(400, "D"));
        checkEquals("B", m.putIfAbsent(200, "E"));
        checkEquals(null, m.putIfAbsent(50, "Z"));
        String[] expected = {"Z","C","B","A","D"};

        checkIterable(expected, m.entrySet());
        System.out.println("passed putIfAbsent");
    }
}
