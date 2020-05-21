package xin.sunce.chapter5.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题实现类
 */
public class SubjectImpl implements Subject {

    List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String msg) {
        for (Observer observer : observers) {
            observer.notify(msg);
        }
    }
}
