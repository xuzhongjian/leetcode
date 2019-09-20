/**
 * date    2019-09-20
 * time    08:48
 * 恶汉式 线程安全单例模式
 *
 * @author thisxzj - 中建
 */
public class Singleton {
    private static Singleton uniqueInstance = new Singleton();

    public Singleton() {
    }

    public Singleton getUniqueInstance() {
        return uniqueInstance;
    }
}
