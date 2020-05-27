package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 短信发送器
 */
public class SmsMessageSender implements MessageSender {

    @Override
    public void send(String msg) {
        System.out.println(String.format("sms sender: %s",msg));
    }
}
