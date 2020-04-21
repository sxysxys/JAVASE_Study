package initandclean;

/**
 * @Author: shenge
 * @Date: 2020-03-31 09:39
 * 静态初始化:在第一次调用类的时候（可以是使用静态方法或者静态变量，也可以是创建这个对象），会加载.Class文件，
 * 这时候会将所有的静态变量都进行加载。以后第二次再创建这个类的时候，这些资源就不再加载了。
 */

class Bowl{
    Bowl(int a){
        System.out.println("bowl("+a+")");
    }
}
class Table{
    Table(int a ){
        System.out.println("Table:"+a);
    }
    static Bowl bowl=new Bowl(1);
    static void cai(){
        System.out.println("菜还蛮多的");
    }
}
public class StaticOrder {
    public static void main(String[] args) {
        Table.cai();  //调用类
        new Table(1);  //第二次使用类
        Table.cai();
    }
}
