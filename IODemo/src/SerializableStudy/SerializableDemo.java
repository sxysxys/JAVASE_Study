package SerializableStudy;

import java.io.*;

/**
 * 将某个对象进行持久化存储和读取。
 * 需要将对象进行序列化。
 */
public class SerializableDemo {
    public static void main(String[] args) throws Exception{
//        writeObj();
        readObj();
    }

    //读取对象
    public static void readObj() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.txt"));
        Object o = objectInputStream.readObject();  //并不是说用object来接受就可以了，返回的肯定是person对象，只是用Object指向它而已。
        System.out.println(o);
        objectInputStream.close();
    }

    //写入对象
    public static void writeObj() throws IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("person.txt"));
        objectOutputStream.writeObject(new Person("lisi","18"));
        objectOutputStream.close();
    }
}

