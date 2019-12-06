package FileDemo;

import java.io.*;
import java.util.List;

/**
 * 需求：将一个目录中的所有java文件的名称打印到一个txt文件中
 * 建立一个java列表文件
 *
 * 思路：
 * 1.对目录进行递归
 * 2.获取到递归的java文件名称
 * 3.将java获取到的名称存储到txt文件中
 */
public class CreateJavaList {

    public static void main(String[] args) throws IOException{
        StringBuilder str=new StringBuilder();
        getJavaList(new File("src"),str);
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("javalist.txt"));
        bufferedWriter.write(str.toString());
        bufferedWriter.close();
    }

    public static void getJavaList(File file, StringBuilder str){
        //这个思路不行，每一次递归都会返回一个file集合，并不是一个集合。
/*        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if (dir.isDirectory()) {
                    getJavaList(dir);
                } else {
                    if (name.endsWith(".java")) {
                        return true;
                    }
                }
                return false;
            }
        });*/
        File[] files1 = file.listFiles();
        for (File file1 : files1) {
            if(file1.isDirectory()){
                getJavaList(file1,str);
            }else {
                if(file1.getName().endsWith(".java"))
                str.append(file1.getAbsolutePath()+"\n");
            }
        }
    }
}
