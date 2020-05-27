package xin.sunce.chapter5.pattern.chain.responsibility;

/**
 * 演示类
 */
public class Demo {


    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new AHandler());
        chain.addHandler(new BHandler());
        chain.handler();
    }
}
