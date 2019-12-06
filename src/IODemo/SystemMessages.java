package IODemo;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

/**
 * 保留系统信息进文件中
 */
public class SystemMessages {
    public static void main(String[] args) throws IOException{
        Properties properties = System.getProperties();
        PrintStream rizhi = new PrintStream("rizhi.txt");
//        System.setOut(rizhi);
        properties.list(rizhi);
    }
}
