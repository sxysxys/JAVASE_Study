package execption;

/**
 * @Author: shenge
 * @Date: 2020-04-10 23:01
 *
 * 异常匹配
 *
 * 匹配顺序：默认能匹配上的第一个catch。
 * 规则：子类的异常需要放到父类的前面去。
 */
class Annoyance extends Exception {}
class Sneeze extends Annoyance {}
public class Human {
    public static void main(String[] args) {
        // Catch the exact type:
        try {
            throw new Sneeze();
        } catch(Sneeze s) {
            System.out.println("Caught Sneeze");
        } catch(Annoyance a) {        //如果将它放到前面，那么编译器会发现Sneeze永远得不到执行，会报错。
            System.out.println("Caught Annoyance");
        }
        // Catch the base type:
        try {
            throw new Sneeze();
        } catch(Annoyance a) {
            System.out.println("Caught Annoyance");
        }
    }
}