import java.io.FileReader;
import java.io.IOException;

/**
 * 自定义打印一行
 */
public class MyBufferDemo {
    public static void main(String[] args) throws IOException{
        MoniBuffer moniBuffer = new MoniBuffer(new FileReader("src/mapdemo.java"));
        String line=null;
        while ((line=moniBuffer.MyReadline())!=null){
            System.out.println(line);
        }
        moniBuffer.myclose();
    }
}

class MoniBuffer{
    private FileReader r;
    MoniBuffer(FileReader r){
        this.r=r;
    }
    public String MyReadline() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        int ch=0;
        //最后一行得有换行符
        while((ch=r.read())!=-1){
            if (ch=='\n'){
                return stringBuilder.toString();
            }
            stringBuilder.append((char)ch);
        }
        //解决了没有换行符的问题
        if(stringBuilder.length()!=0){
            return stringBuilder.toString();
        }
        return null;
    }

    public void myclose() throws IOException{
        r.close();
    }
}
