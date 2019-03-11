package xin.sunce.pattern.proxy;

/**
 * 动态代理示例
 * cglib代理
 *
 * @author lowrie
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        PayInterface payInterface = new PayImpl();
        CglibPayProxy cglibPayProxy = new CglibPayProxy();
        PayInterface instance = (PayInterface) cglibPayProxy.getInstance(payInterface);
        instance.pay();
    }
}
