package IODemo;

import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将异常日志信息打印到文件中。
 * 实际上还是得用log4j
 */
public class FilePrint {
    public static void main(String[] args) {
        try{
            int[] ints = new int[2];
            System.out.println(ints[3]);
        }catch (Exception e){
            try{
                Date d=new Date();
                SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String format = df.format(d);
                PrintStream printStream = new PrintStream("rizhi.txt");
                printStream.println(format);
                System.setOut(printStream);
            }catch (IOException ee){
                throw new RuntimeException("日志创建失败");
            }
            e.printStackTrace(System.out);
        }
    }
}
