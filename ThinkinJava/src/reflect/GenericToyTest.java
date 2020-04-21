package reflect;

/**
 * @Author: shenge
 * @Date: 2020-04-13 22:07
 *
 * 父类对象class引用方法，这是编译器的含糊造成的。
 */
public class GenericToyTest {
    public static void main(String[] args) throws Exception {
        Class<FancyToy> ftClass = FancyToy.class;
        // Produces exact type:
        FancyToy fancyToy = ftClass.newInstance();
        Class<? super FancyToy> up = ftClass.getSuperclass();
        // This won't compile:
        // Class<Toy> up2 = ftClass.getSuperclass();
        // Only produces Object:
        Object obj = up.newInstance();
        Class<? extends Toy> toy=FancyToy.class;
        Toy toy1 = (FancyToy)toy.newInstance();

    }

}
