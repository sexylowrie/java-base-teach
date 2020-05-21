package xin.sunce.chapter5.pattern.observer;

/**
 * 观察者简单演示Demo
 */
public class Demo {

    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        subject.registerObserver(new OneObserverImpl());
        subject.registerObserver(new TwoObserverImpl());
        subject.notifyObserver("Hello world!");
    }
}
