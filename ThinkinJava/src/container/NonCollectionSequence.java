package container;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: shenge
 * @Date: 2020-04-06 23:26
 */
class PetSequence {
    Pet[] pets = {new Pet(),new Pet(),new Pet(),new Pet(),new Pet(),new Pet(),new Pet(),new Pet()};
}

class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p + ":" + " ");
        }
        System.out.println();
    }

}
public class NonCollectionSequence extends PetSequence {
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < pets.length;
            }
            @Override
            public Pet next() { return pets[index++]; }
            @Override
            public void remove() { // Not implemented
                throw new UnsupportedOperationException();
            }
        };
    }
    public static void main(String[] args) {
        NonCollectionSequence nc =
                new NonCollectionSequence();
        InterfaceVsIterator.display(nc.iterator());
    }
}
