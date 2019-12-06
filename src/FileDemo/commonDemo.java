package FileDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * File类初学
 *  1.创建文件：createNewFile()
 *  创建目录：mkdir()创建一级目录，mkdirs()创建多级目录
 *  2.删除：delete()、deleteOnExit()
 *  3.判断：exists()：文件是否存在
 *  isFile()：是否是文件 i
 *  isDirectory():是否是目录
 *  isHidden:是否是隐藏文件
 *  isAbsolutePath:是否是绝对路径
 *  canExecute():是否可执行
 *  4.获取：
 */
public class commonDemo {
    public static void main(String[] args) throws IOException{
//        method_1();
//        method_2();
        method_6();
    }

    //创建层级文件
    public static void method_1() throws IOException{
//        File a=new File("FileResource"+File.separator+"file.txt");
        File mk=new File("abc");
        System.out.println("create mkdir:"+mk.mkdir());
          File a=new File(mk,"file.txt");
        System.out.println("create:"+a.createNewFile());
    }

   //删除文件,但是如果文件正在被流操作，则不能删除，可以执行deleteOnExit()方法。
   public static void method_2() {
        File a=new File("File.txt");  //不区分大小写
        a.deleteOnExit(); //虚拟机终止的时候运行删除
//       System.out.println("delete:"+a.delete());
   }
    //判断文件的状态
   public static void method_3(){
        File f=new File("rizhi.txt");
       System.out.println("excute:"+f.canExecute()); //判断当前文件是否可执行，即是否存在这个文件
   }

   //获取文件的状态信息
   public static void method_4(){
       File a=new File("abc"+File.separator+"method_4.txt");
       File b=new File("abc"+File.separator+"file.txt");
       //获取路径和有没有文件没有关系，只是获取它创建文件的时候封装的路径。
       System.out.println("path:"+a.getAbsolutePath());  //并不会创建文件,返回绝对路径
       System.out.println("xiangduipath:"+a.getPath());  //封装的什么路径，就返回什么路径
       System.out.println("parentpath:"+a.getParent());  //获取父路径，但是传入的必须得是绝对路径，要不然返回空。
       SimpleDateFormat last=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println("lasttime:"+last.format(b.lastModified()));  //获取父路径，但是传入的必须得是绝对路径，要不然返回空。
       File[] files = File.listRoots(); //列出有效盘符。
       for (File file : files) {
           System.out.println(file);
       }
   }

   //重命名文件,也可以使用绝对路径模拟出剪切的效果。
   public static void method_5(){
       File a=new File("abc"+File.separator+"method_4.txt");
       File b=new File("abc"+File.separator+"file.txt");
       System.out.println("rename:"+b.renameTo(a));
   }

   //打印某一个盘符下的所有文件目录，包含隐藏文件
   public static void method_6(){
       File a=new File("c:"+File.separator);
       String[] list = a.list();//调用list的File对象必须封装一个目录，而且该目录还必须存在，要不返回空指针异常。
       for (String s : list) {
           System.out.println(s);
       }
       File[] files = a.listFiles();
       for (File file : files) {
           System.out.println(file.getName()+":"+file.length());  //length返回字节数，文件夹不返回
       }
   }
}
