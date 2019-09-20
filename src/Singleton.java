/**
 * date    2019-09-20
 * time    08:48
 * 静态内部类实现方式
 *
 * @author thisxzj - 中建
 */
public class Singleton {

    private static class Inner {
        private static final Singleton singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        return Inner.singleton;
    }
}
