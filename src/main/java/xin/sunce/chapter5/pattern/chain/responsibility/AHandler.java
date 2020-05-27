package xin.sunce.chapter5.pattern.chain.responsibility;

public class AHandler implements Handler{

    @Override
    public void doHandle() {
        System.out.println("Handler is A.");
    }
}
