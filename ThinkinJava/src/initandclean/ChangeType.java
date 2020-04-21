package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-30 21:01
 */
public class ChangeType {
    public static void main(String[] args) {
        int x = 1;
        ChangeType changeType = new ChangeType();
        changeType.test((double) x);

    }

    public void test(double x){
        System.out.println(x);
    }
}
