package com.sxy.Tcp;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 浏览器作为客户端
 */
public class BrowserServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(11000);
        Socket accept = serverSocket.accept();
        System.out.println(accept.getInetAddress().getHostAddress()+"......connected");
        PrintWriter pw = new PrintWriter(accept.getOutputStream(), true);
        pw.println("你好啊");
        accept.close();
        serverSocket.close();
    }
}
