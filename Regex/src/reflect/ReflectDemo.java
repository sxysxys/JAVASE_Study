package reflect;


import domain.Person;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        //第一种方法
        Class cls = Class.forName("domain.Person");
        System.out.println(cls);
        //第二种方法
        Class cls2 = Person.class;
        System.out.println(cls2);
        //第三种方法
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);
    }

}
