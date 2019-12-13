package ByteDemo;


import java.io.*;

/**
 * 自己写字节buffered缓冲区
 * 1.建立一个数组
 * 2.建立一个指针
 * 3.定义计数器
 */
public class MyByfferedInputStream {
    private FileInputStream inputStream;
    MyByfferedInputStream(FileInputStream inputStream){
        this.inputStream=inputStream;
    }
    private byte[] mybuffer=new byte[1024];
    private int num=0,count=0;
    public int myRead() throws IOException{   //返回int其实是对字节的提升
        if(count==0){
            count = inputStream.read(mybuffer);
            if(count<0){
                return -1;
            }
            num=0;
            byte b=mybuffer[num];
            count--;
            num++;
            return b&255;
        }else if(count>0){
            byte b=mybuffer[num];
            count--;
            num++;
            return b&0xff;
        }else {
        return -1;
        }
    }
    public void myclose() throws IOException{
        inputStream.close();
    }
}

class MyBufferTest{
    public static void main(String[] args) throws IOException{
        MyByfferedInputStream myByfferedInputStream = new MyByfferedInputStream(new FileInputStream("C:\\Users\\shen\\Pictures\\Camera Roll\\xjpic.jpg"));
        BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream("test2.jpg"));
        int count=0;
        while ((count=myByfferedInputStream.myRead())!=-1){    //保证不读出来是-1
            bufferedOutputStream.write(count);  //强转成低8位
        }
        myByfferedInputStream.myclose();
        bufferedOutputStream.close();
    }
}
