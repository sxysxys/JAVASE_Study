package generics;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: shenge
 * @Date: 2020-04-17 21:38
 * <p>
 * 集合的动态类型检查。
 */
class Pet {
}

class Cat extends Pet {
}

class Dog extends Pet {
}

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println("Expected: " + e);
        }
        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
