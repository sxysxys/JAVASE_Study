package generics;

/**
 * @Author: shenge
 * @Date: 2020-04-17 00:23
 *
 * 经典案例：一层一层的T的向下转型。
 */
class HoldItem<T> {  //Object
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}

class WithColor2<T extends HasColor>   //HasColor
        extends HoldItem<T> {
    WithColor2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();  //每次用到T的参数都会将Object转成HasColor
    }
}

class WithColorCoord2<T extends Coord & HasColor>
        extends WithColor2<T> {   //把WithColor2里的所有元素当成T。都会自动往下转。
    WithColorCoord2(T item) {
        super(item);
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }
}

class Solid2<T extends Coord & HasColor & Weight>
        extends WithColorCoord2<T> {
    Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();  //item终究在底层还是T，会自动动转成Coord & HasColor & Weight。
    }
}

public class InheritBounds {
    public static void main(String[] args) {
        Solid2<Bounded> solid2 =
                new Solid2<>(new Bounded());
        solid2.color();
        solid2.getY();
        solid2.weight();
    }
}
