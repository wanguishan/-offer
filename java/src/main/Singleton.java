package main;

/**
 * 实现单例模式
 *
 * 单例对象 占用资源少，不需要延时加载，枚举 好于 饿汉式
 * 单例对象 占用资源多，需要延时加载，静态内部类 好于 懒汉式
 *
 * @author Guishan Wan
 * @date 2020/4/1 8:49 下午
 */
public class Singleton {

/*    // 懒汉式
    private static Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {        // 加synchronized保证线程安全
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }*/

/*    // 饿汉式
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }*/

/*    // 双重校验锁（double-checked locking）
    private volatile static Singleton singleton;    // volatile可以禁止JVM的指令重排，保证在多线程环境下也能正常运行

    private Singleton() {}

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    // 静态内部类
    private static class SingletonHolder {
        private static final Singleton instance = new Singleton();
    }

    private Singleton() {}

    public static final Singleton getInstance() {
        return SingletonHolder.instance;
    }

/*    // 枚举
    public enum Singleton {

        // 枚举元素本身就是单例
        INSTANCE;
        // 添加自己需要的操作
        public void whateverMethod() {
        }
    }*/


}
