package xin.sunce.pattern.proxy;

/**
 * 支付接口实现类
 *
 * @author lowrie
 */
public class PayImpl implements PayInterface {

    @Override
    public String pay() {
        System.out.println("支付成功");
        return "pay success";
    }
}
