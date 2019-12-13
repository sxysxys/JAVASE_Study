package OtherIODemo;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 需求：将txt文件切割成几个碎片文件
 */
public class SplitDemo {
    public static void main(String[] args) throws IOException{
        merge();
    }

    //切割方法
    public static void split() throws IOException{
        FileInputStream fileInputStream = new FileInputStream("hebing.txt");
        FileOutputStream fos=null;
        byte[] buf=new byte[100];
        int count=0;
        int num=1;
        while((count=fileInputStream.read(buf))!=-1){
            fos = new FileOutputStream("d:\\splitfiles\\" + (num++) + ".part");
            fos.write(buf,0,count);
            fos.close();
        }
        fileInputStream.close();
    }

    //合并方法
    public static void merge() throws IOException{
        Vector<FileInputStream> vectors=new Vector<>();
        File a=new File("d:\\splitfiles");
        int length = a.list().length;
        for (int i = 0; i < length; i++) {
            vectors.add(new FileInputStream("d:\\splitfiles\\"+(i+1)+".part"));
        }
        Enumeration<FileInputStream> elements = vectors.elements();
        SequenceInputStream sequenceInputStream = new SequenceInputStream(elements);
        FileOutputStream out=new FileOutputStream("merge.txt");
        int count=0;
        byte[] bytes=new byte[1024];
        while ((count=sequenceInputStream.read(bytes))!=-1){
            out.write(bytes,0,count);
        }
        out.close();
        sequenceInputStream.close();
    }
}
