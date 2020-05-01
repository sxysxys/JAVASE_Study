package com.sxy.Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * udp接收端，用于接收和处理数据的
 * 思路：
 * 1.定义udp socket服务
 * 2.定义一个数据包，因为要存储接收到的字节数据。
 * 3.通过socket的receive方法将收到的数据存入已定义好的数据包中。
 * 4.通过数据包对象的功能，将特有数据取出。打印在控制台上。
 * 5.关闭资源。
 *
 */
public class UdpReceive {
    public static void main(String[] args) throws Exception{
        //创建socket，建立端点。
        DatagramSocket ds = new DatagramSocket(10000);
        while (true) {
            //定义数据包，存储数据
            byte[] buff = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buff, buff.length);
            //通过receive方法将数据存入数据包中。
            ds.receive(dp);
            //通过数据包中的方法提取出数据。
            String ip = dp.getAddress().getHostAddress();  //ip地址
            String data = new String(dp.getData(), 0, dp.getLength());  //传输的数据
            int port = dp.getPort();  //端口号为发送端端口
            System.out.println(ip + "::" + data + "::" + port);
        }
        //关闭资源
//        ds.close();
    }
}
