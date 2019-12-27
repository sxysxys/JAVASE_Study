package com.sxy.Tree.HuffemanCode;

import java.io.*;
import java.util.*;

/**
 * 赫夫曼编码转换
 */
public class HuffmanCodeDemo {
    public static StringBuilder sb=new StringBuilder();
    public static Map<Byte,String> huffCodes=new HashMap<>();

    public static void main(String[] args) {
        String msg="can you can a can as a can canner can a can";
        byte[] bytes = msg.getBytes();
        byte[] b=huffmanZip(bytes);
/*        System.out.println(bytes.length);
        System.out.println(b.length);*/
        //使用赫夫曼编码进行解码
        byte[] bytes1=decodes(b,huffCodes);
//        System.out.println(Arrays.toString(bytes));
//        System.out.println(Arrays.toString(bytes1));
//        System.out.println(new String(bytes1));
        try {
//            zipFile("C:\\Users\\shen\\Pictures\\123.png","copy1.zip");
            unZip("copy1.zip","78.png");
        }catch (Exception e){
            throw new RuntimeException("文件读写出错");
        }

    }

    /**
     * 压缩文件
     * @param src
     * @param dsc
     * @throws IOException
     */
    public static void zipFile(String src,String dsc) throws IOException{
        InputStream fileInputStream = new FileInputStream(src);
        byte[] bytes = new byte[fileInputStream.available()];
        fileInputStream.read(bytes);
        fileInputStream.close();
        byte[] bytes1 = huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(bytes1.length);
        //输出流
        FileOutputStream fileOutputStream = new FileOutputStream(dsc);
        ObjectOutputStream os = new ObjectOutputStream(fileOutputStream);
        os.writeObject(bytes1);
        os.writeObject(huffCodes);
        os.close();

    }

    public static void unZip(String src ,String dsc)throws Exception{
        FileInputStream is = new FileInputStream(src);
        //读取byte数组
        ObjectInputStream objectInputStream = new ObjectInputStream(is);
        byte[] b = (byte[])objectInputStream.readObject();
        Map<Byte,String>  o = (Map<Byte,String>)objectInputStream.readObject();
        objectInputStream.close();
        byte[] decodes = decodes(b, o);
        FileOutputStream fileOutputStream = new FileOutputStream(dsc);
        fileOutputStream.write(decodes);
        fileOutputStream.close();
    }
    /**
     * 解码原来的赫夫曼表
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] decodes(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<bytes.length;i++){
            boolean flag=(i==bytes.length-1);
            String str=byteToStr(bytes[i],!flag);
            sb.append(str);
        }
        //拿到了StringBuilder字符串
//        System.out.println(sb.toString());
        //将原来map里的key-val进行一个调换。
        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        Set<Map.Entry<Byte, String>> entries = huffCodes.entrySet();
        for (Map.Entry<Byte, String> entry : entries) {
            stringByteHashMap.put(entry.getValue(),entry.getKey());
        }
//        Byte[] yuan;  不能这样写，因为不知道数组有多长
        //创建一个集合，用于存放byte数组
        List<Byte> bytes1 = new ArrayList<>();
        int count=1;
        for (int i = 0; i < sb.length();) {
            if (stringByteHashMap.get(sb.substring(i,i+count))!=null){
                Byte aByte = stringByteHashMap.get(sb.substring(i, i + count));
//                System.out.println(aByte);
                bytes1.add(aByte);
                i+=count;
                count=0;
            }
            count++;
        }
        //将list转成byte数组
        byte[] bb=new byte[bytes1.size()];
        for (int i = 0; i < bb.length; i++) {
            bb[i]=bytes1.get(i);
        }
        return bb;
    }

    /**
     * 将一个字节转成相应的字节字符串
     * @param b
     * @return
     */
    private static String byteToStr(byte b,boolean flag) {
        int temp=b;
        if (flag){
            temp|=256;
            String str=Integer.toBinaryString(temp);
            return str.substring(str.length() - 8);
        }else {
            return Integer.toBinaryString(temp);
        }
    }


    /**
     * 将原始字节数组压缩成赫夫曼数组
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes) {
        //先统计传入的字节数量,每一个字节出现的次数作为list集合返回
        List<Node> nodes=getlist(bytes);
//        System.out.println(nodes);
        //创建一个赫夫曼树
        Node huffman = createHuffman(nodes);
//        System.out.println(huffman);
        //创建每个字符所对应编码，即编码表
        Map<Byte,String> codes = createCodeList(huffman);
//        System.out.println(codes);
        //将加密数组和编码表进行压缩加密
        byte[] zipVal=zip(bytes,codes);
        return zipVal;
    }

    /**
     * 将原始数组和map，输出对应的zipVal数组
     * @param bytes
     * @param codes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> codes) {
        StringBuilder sb=new StringBuilder();
        for(byte b : bytes){
            sb.append(codes.get(b));
        }
//        System.out.println(sb.toString());
        int len;
        if (sb.length()%8==0){
            len=sb.length()/8;
        }else {
            len=sb.length()/8+1;
        }
        byte[] zipBytes=new byte[len];
        int index=0;
        for (int i = 0; i < sb.length(); i+=8) {
            String str;
            if(i+8<sb.length()) {
                str=sb.substring(i, i + 8);
            }else {
                str=sb.substring(i);
            }
//            System.out.println(str);
            byte i1 = (byte) Integer.parseInt(str, 2);
            zipBytes[index++]=i1;
        }

        return zipBytes;
    }

    /**
     * 创建赫夫曼编码表
     * @param huffman
     * @return
     */


    public static Map<Byte, String> createCodeList(Node huffman) {
        if (huffman==null){
            return null;
        }
        getCodes(huffman.left,"0",sb);
        getCodes(huffman.right,"1",sb);
        return huffCodes;
    }

    /**
     *
     * @param huffman  送入的根节点
     * @param s   送入的字符拼接 0或1
     * @param sb   存储map的字符编码
     */
    public static void getCodes(Node huffman, String s, StringBuilder sb) {
        StringBuilder sb2=new StringBuilder(sb);
        sb2.append(s);
        if (huffman.data==null){
            getCodes(huffman.left,"0",sb2);
            getCodes(huffman.right,"1",sb2);
        }else {
            huffCodes.put(huffman.data,sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    public static Node createHuffman(List<Node> nodes){
        while (nodes.size()>1){
            Collections.sort(nodes);
            Node left= nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node newnode = new Node(left.weight + right.weight);
            newnode.left=left;
            newnode.right=right;
            nodes.remove(nodes.size()-2);
            nodes.remove(nodes.size()-1);
            nodes.add(newnode);
        }
        return nodes.get(0);
    }

    /**
     * 得到一个List，里面存放node，node中有相应字符和权
     * @param bytes
     * @return
     */
    private static List<Node> getlist(byte[] bytes) {
        List<Node> nodes =new ArrayList<>();  //里面node存放各个节点的属性
        Map<Byte,Integer> counts=new HashMap<>();
        for (Byte b : bytes) {
            Integer count = counts.get(b);
            if (count ==null){  //如果不存在
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        //将map集合创建好了,将map遍历进list中。
        for (Map.Entry<Byte,Integer> entry: counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
}
