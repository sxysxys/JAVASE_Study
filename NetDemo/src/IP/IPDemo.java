package IP;

import java.net.InetAddress;

public class IPDemo {
    public static void main(String[] args) throws Exception{
        InetAddress localHost = InetAddress.getLocalHost(); //返回主机ip地址
        System.out.println(localHost);
        System.out.println("address="+localHost.getHostAddress());
        System.out.println("name="+localHost.getHostName());
    }
}
