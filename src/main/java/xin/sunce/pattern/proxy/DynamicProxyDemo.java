package xin.sunce.pattern.proxy;

/**
 * 代理模式示例
 * jdk动态代理
 *
 * @author lowrie
 */
public class DynamicProxyDemo {

    public static void main(String[] args) {
        DynamicPayProxy proxy = new DynamicPayProxy();
        PayInterface payInstance = (PayInterface) proxy.newProxyInstance(new PayImpl());
        payInstance.pay();
    }
}
