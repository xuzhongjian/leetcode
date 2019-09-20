/**
 * date    2019-09-20
 * time    08:48
 * 懒汉式，线程不安全单例模式
 *
 * @author thisxzj - 中建
 */
public class Singleton {
    private static Singleton uniqueInstance;

    public Singleton() {
    }

    public Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
