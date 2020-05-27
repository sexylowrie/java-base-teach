package xin.sunce.chapter5.pattern.action.template;

/**
 * 扑克游戏
 *
 * @author lowrie
 * @date 2019-09-02
 */
public class PokerGame extends GameTemplate {


    @Override
    void doInit() {
        System.out.println("PokerGame init poker resources.");
    }

    @Override
    void doStart() {
        System.out.println("PokerGame start.");
    }

    @Override
    void doEnd() {
        System.out.println("PokerGame end.");
    }
}
