package xin.sunce.chapter5.pattern.action.chain;

/**
 * 责任链模式演示类
 */
public class Demo {


    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new AHandler());
        chain.addHandler(new BHandler());
        chain.handler();
    }
}
