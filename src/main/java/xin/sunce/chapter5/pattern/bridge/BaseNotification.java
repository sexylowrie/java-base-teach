package xin.sunce.chapter5.pattern.bridge;

/**
 * 抽象通知类
 */
public abstract class BaseNotification {

    protected MessageSender messageSender;

    public BaseNotification(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public abstract void notify(String message);
}
