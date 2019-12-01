package ByteDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 需求：复制一张图片
 *
 * 1.通过字节流与被存储的图片关联
 * 2.用字节流创建一个图片文件对象，用于存储
 * 3.完成存储，关闭资源。
 *
 */
public class Copyimages {
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = null;
        FileInputStream inputStream=null;
        try {
            inputStream=new FileInputStream("C:\\Users\\shen\\Pictures\\Camera Roll\\xjpic.jpg");
            fileOutputStream=new FileOutputStream("copy.jpg");
            int num=0;
            byte[] shou=new byte[1024];
            while((num=inputStream.read(shou))!=-1){
                fileOutputStream.write(shou,0,num);
            }
        }catch (IOException e){
            throw new RuntimeException("复制操作失败！");
        }finally {
            try {
                if(inputStream!=null){
                    inputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }catch (IOException e){
                throw new RuntimeException("关闭失败！");
            }
        }
    }
}
