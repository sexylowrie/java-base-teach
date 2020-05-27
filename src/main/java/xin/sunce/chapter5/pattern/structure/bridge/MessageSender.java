package xin.sunce.chapter5.pattern.structure.bridge;

/**
 * 消息发送者
 */
public interface MessageSender {

    /**
     * 发送方案
     *
     * @param msg 消息
     */
    void send(String msg);
}
