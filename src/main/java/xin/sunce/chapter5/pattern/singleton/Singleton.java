package xin.sunce.chapter5.pattern.singleton;

/**
 * 枚举型单例
 * 枚举类默认就是线程安全的，
 * 只能通过Singleton.INSTANCE 访问，比getInstance方便很多
 * 还能防止反序列化跟反射攻击
 */
public enum Singleton {

    INSTANCE;
}
