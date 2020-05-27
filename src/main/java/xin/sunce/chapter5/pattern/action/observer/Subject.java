package xin.sunce.chapter5.pattern.action.observer;

/**
 * 主题
 */
public interface Subject {

    /**
     * 添加观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObserver(String msg);

}
