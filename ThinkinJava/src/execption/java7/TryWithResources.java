package execption.java7;

/**
 * @Author: shenge
 * @Date: 2020-04-10 22:41
 *
 * try()中创建的对象需要实现AutoCloseable接口，也就是要有close方法
 * 当出了try块的时候，这些对象会自动掉用它们的close方法，也就不需要自己去关闭了
 * 防止要在异常处理中进行有无打开文件的判断。
 */
import java.io.*;
public class TryWithResources {
    public static void main(String[] args) {
        try(
                InputStream in = new FileInputStream(
                        new File("Cheese.dat"))
        ) {
            int contents = in.read();
            // Process contents
        } catch(IOException e) {
            // Handle the error
        }
    }
}
