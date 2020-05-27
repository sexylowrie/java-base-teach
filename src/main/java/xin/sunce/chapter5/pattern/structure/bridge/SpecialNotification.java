package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 特殊消息通知类
 */
public class SpecialNotification extends BaseNotification {


    public SpecialNotification(MessageSender messageSender) {
        super(messageSender);
    }

    public void notify(String message) {
        System.out.println("特殊通知：");
        messageSender.send(message);
    }
}
