package Properties;

import java.io.*;
import java.util.Properties;

/**
 * 用于记录应用程序运行次数
 * 次数已到，出现注册提示
 *
 * 这里需要使用properties，因为需要在程序结束的时候实现掉电的存储。
 * 创建一个配置文件，实现掉电存储。
 */
public class RunTimes {
    public static void main(String[] args) throws IOException{
        Properties pro=new Properties();
        File a=new File("ttt.properties");
        if (!a.exists()){
            a.createNewFile();
        }
        FileInputStream aa=new FileInputStream(a);
        pro.load(aa);
        int count=0;
        String value=pro.getProperty("times");
        if(value!=null){
            count=Integer.parseInt(value);
            if (count>=5){
                System.out.println("您需要注册了！！");
            }
        }
        count++;
        pro.setProperty("times",count+"");
        FileOutputStream fw=new FileOutputStream(a);
        pro.store(fw,"");
        aa.close();
        fw.close();
    }
}
