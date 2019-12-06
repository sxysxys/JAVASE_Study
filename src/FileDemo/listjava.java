package FileDemo;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 需求：列出一个文件夹下的所有.java文件
 */
public class listjava {
    public static void main(String[] args) {
        File file = new File("src" + File.separator + "FileDemo");
        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
