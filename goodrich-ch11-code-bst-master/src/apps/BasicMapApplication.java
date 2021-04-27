package apps;

import net.datastructures.Map;
import net.datastructures.UnsortedTableMap;

public class BasicMapApplication {
    public static void main(String[] args) {
        Map<Cat, Integer> cutenessScore = new UnsortedTableMap<>();
        cutenessScore.put(new Cat(10, "Siamese"), 8);
        cutenessScore.put(new Cat(5, "Tabby"), 42);

        System.out.println(cutenessScore.get(new Cat(10, "Siamese")));
        System.out.println(cutenessScore.get(new Cat(5, "Tabby")));
        System.out.println(cutenessScore.get(new Cat(5, "Tabby")));
        System.out.println(cutenessScore.get(new Cat(2, "Sphynx")));
        System.out.println(cutenessScore.get(new Cat(10, "Siamese")));
        System.out.println(cutenessScore.get(new Cat(5, "Tabby")));
    }
}
