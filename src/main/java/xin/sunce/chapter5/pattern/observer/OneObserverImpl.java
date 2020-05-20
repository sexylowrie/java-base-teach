package xin.sunce.chapter5.pattern.observer;

public class OneObserverImpl implements Observer {

    @Override
    public void notify(String msg) {
        System.out.println("I am one ,receive notify:" + msg);
    }
}
