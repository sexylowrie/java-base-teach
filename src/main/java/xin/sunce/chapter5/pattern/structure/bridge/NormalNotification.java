package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 普通消息通知类
 */
public class NormalNotification extends BaseNotification {


    public NormalNotification(MessageSender messageSender) {
        super(messageSender);
    }

    public void notify(String message) {
        System.out.println("普通通知：");
        messageSender.send(message);
    }
}
