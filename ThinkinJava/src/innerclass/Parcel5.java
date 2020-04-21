package innerclass;

/**
 * @Author: shenge
 * @Date: 2020-04-02 15:59
 *
 * 在方法中定义内部类，必须返回一个能够被编译器识别的类型。例如一个通用接口。
 * 由于类在方法中定义，如果方法直接返回在方法中定义的类，那么在mian方法中识别不到这个类。
 * 而且在方法中实实在在在内存中创建了这个对象，返回引用后相当于d这个引用就指向了创建的对象，这个对象不随着方法结束而消失。
 * 但是方法中定义的这个内部类型会随着方法结束消失。
 */
public class Parcel5 {
    public Destination destination(String s) {
        final class PDestination implements Destination {
            private String label;

            private PDestination(String whereTo) {
                label = whereTo;
            }

            @Override
            public String readLabel() { return label; }
        }
        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();
        Destination d = p.destination("Tasmania");
    }
}
