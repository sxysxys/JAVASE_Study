package execption;

/**
 * @Author: shenge
 * @Date: 2020-04-10 20:24
 *
 * java异常的bug。
 */
class VeryImportantException extends Exception {
    @Override
    public String toString() {
        return "A very important exception!";
    }
}
class HoHumException extends Exception {
    @Override
    public String toString() {
        return "A trivial exception";
    }
}
public class LostMessage {
    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        throw new HoHumException();
    }
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                lm.dispose();    //第一个异常还没处理完就抛出下一个异常。
            }
        } catch(VeryImportantException | HoHumException e) {
            System.out.println(e);
        }
    }
}