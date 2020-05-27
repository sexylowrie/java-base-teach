package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 桥接模式演示类
 */
public class Demo {


    public static void main(String[] args) {
        MessageSender sms = new SmsMessageSender();
        MessageSender wechat = new WechatMessageSender();
        BaseNotification normal = new NormalNotification(sms);
        normal.notify("Hi world！");
        BaseNotification special = new SpecialNotification(wechat);
        special.notify("Hi world！");
    }
}
