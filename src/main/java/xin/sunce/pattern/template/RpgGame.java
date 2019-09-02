package xin.sunce.pattern.template;

/**
 * Rpg游戏
 *
 * @author lowrie
 * @date 2019-09-02
 */
public class RpgGame extends GameTemplate {

    @Override
    void doInit() {
        System.out.println("RpgGame init resources");
    }

    @Override
    void doStart() {
        System.out.println("RpgGame start");
    }

    @Override
    void doEnd() {
        System.out.println("RpgGame end");
    }
}
