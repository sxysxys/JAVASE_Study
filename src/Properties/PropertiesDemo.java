package Properties;

import java.io.*;
import java.util.Properties;

/**
 * 需求：将txt文件中的键值对放入properties集合里面。
 * 1.用一个流与txt文件关联
 * 2.读取一行数据，用=进行切割，=左边作为键，右边作为值存入properties集合中
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("src" + File.separator + "FileDemo" + File.separator + "rizhi.txt");
//        method_1(fileReader);
        loadDemo(fileReader);

    }

    //传统方法读取txt键值对进入properties集合
    public static void method_1(FileReader fileReader)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Properties properties=new Properties();
        String str=null;
        while((str=bufferedReader.readLine())!=null){
            if(str.contains("=")&&!str.endsWith("=")){
                String[] split = str.split("=");
                properties.setProperty(split[0],split[1]);
            }
        }
        bufferedReader.close();
        properties.list(System.out);
    }

    //用load方法载入文件
    public static void loadDemo(FileReader fileReader)throws IOException{
        Properties properties=new Properties();
        properties.load(fileReader);
        properties.setProperty("sun.cpu.isalist","what happend");
        //将对象往流里面写，第二个参数是注释
        properties.store(new FileWriter("src" + File.separator + "FileDemo" + File.separator + "rizhi.txt"), "hahaha");
        properties.list(System.out);
    }
}
