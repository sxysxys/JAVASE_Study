package OtherIODemo;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 需求：将多个txt文件一起读入一个txt文件中。
 * 使用SequenceInputStream类。
 */
public class XulieDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream a=new FileInputStream("javalist.txt");
        FileInputStream b=new FileInputStream("laoer.txt");
        FileInputStream c=new FileInputStream("src"+File.separator+ "FileDemo" + File.separator+"rizhi.txt");

        Vector<FileInputStream> vectors=new Vector<>();
        vectors.add(a);
        vectors.add(b);
        vectors.add(c);

        Enumeration<FileInputStream> elements = vectors.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(elements);
        FileOutputStream fileOutputStream = new FileOutputStream("hebing.txt");
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=sequenceInputStream.read(bytes))!=-1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        sequenceInputStream.close();
    }
}
