package xin.sunce.chapter5.pattern.structure.proxy;

/**
 * 动态代理示例
 * cglib代理
 *
 * @author lowrie
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        CglibPayProxy proxy = new CglibPayProxy();
        PayInterface payInstance = (PayInterface) proxy.newProxyInstance(new PayImpl());
        payInstance.pay();
    }
}
