package com.sxy.Udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpScanner {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line=br.readLine())!=null){
            if ("886".equals(line)){
                break;
            }else {
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("localhost"), 10000);
                ds.send(dp);
            }
        }
        ds.close();
    }
}
