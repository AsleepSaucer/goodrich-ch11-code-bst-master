package apps;

import java.util.Objects;

public class Cat {
    private final int age;
    private final String breed;

    public Cat(int age, String breed) {
        this.age = age;
        this.breed = breed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age &&
                Objects.equals(breed, cat.breed);
    }


    // You may ignore this method for now
    // It is only here to make the HashSet work in BasicSetApplication
    @Override
    public int hashCode() {
        return Objects.hash(age, breed);
    }

}
