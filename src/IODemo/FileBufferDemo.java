package IODemo;

import java.io.*;

/**
 * 完整的通过缓冲区进行复制操作的动作。
 */
public class FileBufferDemo {
    public static void main(String[] args){
        BufferedWriter bufferedWriter=null;
        BufferedReader bufferedReader=null;
        try {
            bufferedWriter= new BufferedWriter(new FileWriter("bufferdemo.txt"));
            bufferedReader=new BufferedReader(new FileReader("src/IODemo.mapdemo.java"));
            String num=null;
            while((num=bufferedReader.readLine())!=null){
                bufferedWriter.write(num);
                bufferedWriter.newLine(); //写入换行符
                bufferedWriter.flush();
            }
        }catch (IOException e){
            throw new RuntimeException("凉了");
        }finally {
            try {
                if (bufferedWriter!=null)
                    bufferedWriter.close();
            }catch (IOException e){
                throw new RuntimeException("读写关闭失败");
            }
            try {
                if (bufferedReader!=null)
                    bufferedReader.close();
            }catch (IOException e){
                throw new RuntimeException("读写关闭失败");
            }
        }
    }
}



