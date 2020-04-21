package generics.ownlimit;

/**
 * @Author: shenge
 * @Date: 2020-04-17 21:13
 *
 * 使用自限定：不能进行方法重写。这就是使用自限定的意义，可以保证只获得方法的一个版本。
 *
 */
interface SelfBoundSetter<T extends SelfBoundSetter<T>> {
    void set(T arg);
}

interface Setter extends SelfBoundSetter<Setter> {
}

public class SelfBoundingAndCovariantArguments {
    void
    testA(Setter s1, Setter s2, SelfBoundSetter sbs) {
        s1.set(s2);
        //- s1.set(sbs);
        // error: method set in interface SelfBoundSetter<T>
        // cannot be applied to given types;
        //     s1.set(sbs);
        //       ^
        //   required: Setter
        //   found: SelfBoundSetter
        //   reason: argument mismatch;
        // SelfBoundSetter cannot be converted to Setter
        //   where T is a type-variable:
        //     T extends SelfBoundSetter<T> declared in
        //     interface SelfBoundSetter
        // 1 error
    }
}
