import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 拷贝文件单字符方法。
 */
public class SystemDemo {
    public static void main(String[] args) throws IOException{
        //创建一个写路径
        FileWriter fileWriter = new FileWriter("xxx.txt");
        //创建一个读路径
        FileReader fileReader = new FileReader("src/mapdemo.java");

        int ch=0;
        while((ch=fileReader.read())!=-1){
            fileWriter.write(ch);
        }
        fileWriter.close();
        fileReader.close();
    }
}

class IODemo{
    public static void main(String[] args) throws IOException{
        FileWriter fileWriter = new FileWriter("laoer.txt");
        FileReader fileReader = new FileReader("src/mapdemo.java");
        char buf[]=new char[1024];
        int num=0;
        if((num=fileReader.read(buf))!=-1){
            fileWriter.write(buf,0,num);
        }
        fileReader.close();
        fileWriter.close();
    }
}
