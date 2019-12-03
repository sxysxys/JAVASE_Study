import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取键盘录入，如果输入数据是over，则停止。
 */
public class ReadinDemo {
    public static void main(String[] args) throws IOException{
        InputStream in = System.in;
        StringBuilder stringBuilder=new StringBuilder();
        while(true){
            int ch=in.read();
            if (ch=='\r'){
                continue;  //windows的回车符是以\r\n结尾的，需要多一层判断，不将这个符号录入。
            }
            if (ch=='\n'){
                String s = stringBuilder.toString();
                if(s.equals("over")){
                    break;
                }
                System.out.println(s);
                stringBuilder.delete(0,stringBuilder.length());
            }else {
            stringBuilder.append((char) ch);      //向下转型！！！
            }
        }
    }
}

/**
 * 使用转换流将字节流转换成字符流
 */
class TransStreamDemo{
    public static void main(String[] args) throws IOException{
        InputStream in =System.in;
        InputStreamReader inputStreamReader=new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String ch=null;
        while((ch=bufferedReader.readLine())!=null){
            if (ch.equals("over")){
                break;
            }
            System.out.println(ch);
        }
        bufferedReader.close();
    }
}
