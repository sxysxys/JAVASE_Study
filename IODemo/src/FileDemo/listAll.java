package FileDemo;

import java.io.File;

/**
 * 需求：1.列出指定目录下的文件或者文件夹，包含子目录的所有内容;
 * 2.删除一个文件夹中的所有文件
 * 做法：通过递归完成，写一个方法，传入目录或者文件，判断后如果是目录则再调用自身。
 */
public class listAll {
    public static void main(String[] args) {
//       listdir(new File("src"));
//        System.out.println(File.separator);
       deletedir(new File("D:"+File.separator+"资料"+File.separator+"冲浪板电路图及程序V0.4（枪控增加标定）(1)"));
    }

    //显示一个文件夹中的所有文件
    public static void listdir(File file){
        System.out.println(file);
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                listdir(file1);
            }else {
                System.out.println(file1);
            }
        }
    }
    //删除一个文件夹下的所有文件
    public static void deletedir(File file){
        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()){
                deletedir(file1);
            }else {
                System.out.println(file1.toString()+":"+file1.delete());
            }
        }
        file.delete();
    }
}
