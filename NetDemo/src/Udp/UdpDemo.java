package Udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 通过udp将文字发送出去。
 * 思路：
 * 1.建立udp socket
 * 2.提供数据，将数据封装在数据包中。
 * 3.通过socket发送出去
 * 4.关闭资源
 */
public class UdpDemo {
    public static void main(String[] args) throws Exception{
        //创建udp socket
        DatagramSocket ds = new DatagramSocket();
        //确定数据，封装成数据包
        byte[] bytes="udp is niubi".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"),10000);
        //发送
        ds.send(datagramPacket);
        //关闭
        ds.close();
    }
}

