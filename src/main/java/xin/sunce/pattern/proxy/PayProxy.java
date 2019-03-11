package xin.sunce.pattern.proxy;

/**
 * 支付代理类
 */
public class PayProxy implements PayInterface {

    public PayProxy(PayInterface payInterface) {
        this.payInterface = payInterface;
    }

    private PayInterface payInterface;

    @Override
    public String pay() {
        System.out.println("进入代理类");
        return payInterface.pay();
    }
}
