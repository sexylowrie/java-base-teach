package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 微信发送器
 */
public class WechatMessageSender implements MessageSender {

    @Override
    public void send(String msg) {
        System.out.println(String.format("wechat sender: %s",msg));
    }
}
