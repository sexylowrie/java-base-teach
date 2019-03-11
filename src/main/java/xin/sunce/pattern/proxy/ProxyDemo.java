package xin.sunce.pattern.proxy;

/**
 * 代理模式示例
 * 静态代理
 */
public class ProxyDemo {


    public static void main(String[] args) {
        PayInterface payImpl = new PayImpl();
        PayProxy payProxy = new PayProxy(payImpl);
        payProxy.pay();
    }

}
