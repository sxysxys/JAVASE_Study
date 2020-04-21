package iostream;

/**
 * @Author: shenge
 * @Date: 2020-04-12 22:54
 *
 * 从内存取到字符串。
 */
import tools.BufferedInputFile;

import java.io.*;

public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(
                BufferedInputFile.read("ThinkinJava/src/iostream/MemoryInput.java"));
        int c;
        while ((c = in.read()) != -1)
            System.out.print((char) c);
    }
}
