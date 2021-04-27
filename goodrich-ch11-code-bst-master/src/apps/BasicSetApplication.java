package apps;

// Java library's Set interface
import java.util.Set;
// one of Java library's implementations of Set interface
import java.util.HashSet;

public class BasicSetApplication {
    public static void main(String[] args) {
        Set<Cat> catsIHave = new HashSet<>(); // Don't worry about what a HashSet is yet; it is one kind of implementation of Set
        catsIHave.add(new Cat(10, "Siamese"));
        catsIHave.add(new Cat(5, "Tabby"));

        System.out.println(catsIHave.contains(new Cat(10, "Siamese")));
        System.out.println(catsIHave.contains(new Cat(5, "Tabby")));
        System.out.println(catsIHave.contains(new Cat(5, "Tabby")));
        System.out.println(catsIHave.contains(new Cat(2, "Sphynx")));
        System.out.println(catsIHave.contains(new Cat(10, "Siamese")));
        System.out.println(catsIHave.contains(new Cat(5, "Tabby")));
    }
}
