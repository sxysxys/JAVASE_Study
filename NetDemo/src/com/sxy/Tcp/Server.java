package com.sxy.Tcp;




import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket的服务端
 * 需求：接收端点数据并打印在控制台上\
 * 1.建立服务端的socket的服务，ServerSocket()，监听一个端口
 * 2.获取连接的客户端对象，accept()
 *3.如果客户端发来了数据，那么服务端需要使用对应的客户端对象，并获取它的读取流来读取发来的数据。打印在控制台
 * 4.关闭服务端
 */
public class Server {
    public static void main(String[] args) throws Exception{
        //建立服务端的socket服务，并监听端口
        ServerSocket serverSocket = new ServerSocket(10003);
        //得到客户端请求的连接,进行三次握手后，得到新的连接套接字，此时tcp连接建立
        Socket accept = serverSocket.accept();
        //获取客户端发来的数据
        String ip = accept.getInetAddress().getHostAddress();
        System.out.println(ip+".....connected");
        InputStream is = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes,0,len));
        accept.close();//关闭连接
        serverSocket.close();
    }
}
class Server2{
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(10004);
        Socket accept = serverSocket.accept();  //建立连接
        String ip = accept.getInetAddress().getHostAddress();
        System.out.println(ip+".....connected");
        InputStream inputStream = accept.getInputStream();
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream os = accept.getOutputStream();
        os.write("收到了奥".getBytes());
        accept.close();
        serverSocket.close();
    }
}

/**
 * 将客户端传来的数据转成大写的
 */
class Server3{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10005);
        Socket accept = serverSocket.accept();
        String ip = accept.getInetAddress().getHostAddress();
        System.out.println(ip+"......connected");
        BufferedReader br = new BufferedReader(new InputStreamReader(accept.getInputStream()));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        PrintWriter bw = new PrintWriter(accept.getOutputStream(), true);
        String line=null;
        while ((line=br.readLine())!=null){
            bw.println(line.toUpperCase());
        }
        accept.close();
        serverSocket.close();
    }
}
