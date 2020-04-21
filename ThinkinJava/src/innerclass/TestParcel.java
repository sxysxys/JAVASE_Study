package innerclass;

/**
 * @Author: shenge
 * @Date: 2020-04-02 15:06
 *
 * 内部类的典型用途，封装相应的实现，使得用户不能拿到相应实现接口的类的实体。
 * 使得用户拿到接口引用以后不能向下转型，不能调用任何除接口以外的方法。
 */

interface Contents {
    int value();
}

interface Destination {
    String readLabel();
}

class Parcel4 {
    private int test_inter = 5;
    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        PDestination(String whereTo) {
            label = whereTo;
            test_inter=6;
        }

        @Override
        public String readLabel() {
            return label;
        }
    }


    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

}

//class xx extends Parcel4.PDestination {
//    public xx(Parcel4 parcel4) {
//        parcel4.super("123");
//    }
//}

public class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();   //不能进行向下转型，只能用接口提供的方法，更纯粹。
        Destination d = p.destination("Tasmania");
        // Illegal -- can't access private class:
        //- Parcel4.PContents pc = p.new PContents();
    }
}
