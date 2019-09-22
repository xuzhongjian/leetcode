/**
 * date    2019-09-20
 * time    08:48
 * 静态内部类实现方式
 *
 * @author thisxzj - 中建
 */
public class Singleton {
    public Singleton() {
    }

    public static class Inner {
        private static final Singleton uniqueInstance = new Singleton();
    }

    public Singleton getUniqueInstance() {
        return Inner.uniqueInstance;
    }
}
