package execption;

/**
 * @Author: shenge
 * @Date: 2020-04-10 20:36
 *
 * 继承和实现的时候异常的形式。
 *
 * 当父类的方法抛异常的时候，子类重写方法的时候只能抛父类异常的子类或者不抛。
 * 原因：父类中其他的方法可能会对抛异常的方法进行处理，当子类重写方法的时候，可以一并处理。
 *
 * 当父类的构造方法抛异常的时候，子类的构造方法必须要抛父类的构造方法异常，同时也可以另外抛出自己的异常。
 * 原因：子类每次执行都要调用父类的构造方法。
 *
 */
// Overridden methods can throw only the exceptions
// specified in their base-class versions, or exceptions
// derived from the base-class exceptions
class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}


abstract class Inning {
    Inning() throws BaseballException {}
    public void event() throws BaseballException {
// Doesn't actually have to throw anything
    }
    public abstract void atBat() throws Strike, Foul;
    public void walk() {} // Throws no checked exceptions
}

class StormException extends Exception {}
class RainedOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    void event() throws RainedOut;
    void rainHard() throws StormException;
}

public class StormyInning extends Inning implements Storm {
    // OK to add new exceptions for constructors, but you
// must deal with the base constructor exceptions:
    public StormyInning()
            throws RainedOut, BaseballException {}
    public StormyInning(String s)
            throws BaseballException {}
    // Regular methods must conform to base class:
//- void walk() throws PopFoul {} //Compile error
// Interface CANNOT add exceptions to existing
// methods from the base class:
//- public void event() throws RainedOut {}
// If the method doesn't already exist in the
// base class, the exception is OK:
    @Override
    public void rainHard() throws RainedOut {}
    // You can choose to not throw any exceptions,
// even if the base version does:
    @Override
    public void event() {}
    // Overridden methods can throw inherited exceptions:
    @Override
    public void atBat() throws PopFoul {}
    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
            si.atBat();
        } catch(PopFoul e) {
            System.out.println("Pop foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
// Strike not thrown in derived version.
        try {
// What happens if you upcast?
            Inning i = new StormyInning();
            i.atBat();      //这里虽然执行的是子类的方法体，但是编译器看到的是Inning，所以会要求处理父类的异常；这里也能看出为什么子类方法的异常必须要是父类方法异常的子异常或者没有了，因为这样都能处理。
// You must catch the exceptions from the
// base-class version of the method:
        } catch(Strike e) {
            System.out.println("Strike");
        } catch(Foul e) {
            System.out.println("Foul");
        } catch(RainedOut e) {
            System.out.println("Rained out");
        } catch(BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
