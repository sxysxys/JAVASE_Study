package Tcp;


import java.io.*;
import java.net.Socket;

/**
 * 演示tcp传输
 * tcp分为客户端和服务端
 * 客户端对应的对象是socket
 * 服务端对应的对象是ServerSocket
 *
 *
 * 客户端在建立的时候就可以连接主机
 * 因为TCP是面向连接的，所以在建立socket建立的时候就要有服务端存在并且连接成功，形成通道后，在该通道开始数据的传输。
 * 需求：给服务端发送一个文本数据
 * 步骤：
 * 1.创建socket服务并连接主机。
 * 2.获取socket的输出流，向输出流里写数据。
 */
public class Client {
    public static void main(String[] args) throws Exception{
        Socket sk = new Socket("localhost", 10003);
        //获取socket流中的输出流,用以向服务器写数据
        OutputStream os = sk.getOutputStream();
        os.write("tcp hello".getBytes());
        sk.close();
    }
}

/**
 * 演示客户端和服务端的互访
 * 需求：客户端给服务端发送数据，服务端收到并反馈数据
 *
 */
class Client2{
    public static void main(String[] args) throws Exception{
        Socket ip = new Socket("localhost", 10004);
        Thread.currentThread().sleep(6000);
        OutputStream os = ip.getOutputStream();
        os.write("hello world".getBytes());
        InputStream is = ip.getInputStream();
        byte[] bytes = new byte[1024];
        int len=is.read(bytes);
        System.out.println(new String(bytes,0,len));
        ip.close();
    }
}

/**
 * 建立一个文本转换服务器。
 * 客户端给服务器发送文本，服务器将文本转成大写再返回给客户端
 * 客户端可以不断的进行文本转换，当客户端输入over时，转换结束
 *
 * 步骤：
 * 1.建立socket连接
 * 2.获取键盘录入
 * 3.将数据发送给服务端
 * 4.获取服务端的转换后的结果
 * 5.关闭资源
 */
class Client3{
    public static void main(String[] args) throws Exception{
        Socket sk = new Socket("localhost", 10005);  //得到连接
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //定义源
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sk.getOutputStream()));//定义目的
        BufferedReader bfIn = new BufferedReader(new InputStreamReader(sk.getInputStream()));  //定义从服务器的读取流
        String line=null;
        while ((line=br.readLine())!=null){
            if (line.equals("over")){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
            String s = bfIn.readLine();
            System.out.println("server:"+s);
        }
        br.close();
        sk.close();
    }
}
