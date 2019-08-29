package xin.sunce.pattern.strategy;

/**
 * 策略模式演示类
 *
 * @author lowrie
 * @date 2019-08-29
 */
public class GoHomeDemo {

    public static void main(String[] args) {
        TaxiStrategy taxi = new TaxiStrategy();
        Content content = new Content(taxi);
        content.execute();
    }

}
